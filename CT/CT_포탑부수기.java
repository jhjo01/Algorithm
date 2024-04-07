import java.util.*;

public class 포탑부수기 {
	static class Laser {
		int x;
		int y;
		int cnt;
		List<int[]> list;
		
		Laser(int x, int y, int cnt, List<int[]> list) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.list = new ArrayList<>();
			for(int i = 0; i < list.size(); i++) {
				this.list.add(list.get(i));
			}
			this.list.add(new int[] {x, y});
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int[][][] tower = new int[N][M][2];
		// 1. 	포탑 입력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tower[i][j][0] = sc.nextInt();
				// 2. 	부서진 포탑 + 최근 공격 저장할 배열 (부서지면 -1, 초기값 0)
				tower[i][j][1] = tower[i][j][0] > 0 ? 0 : -1;
			}
		}
		
		// K만큼 공격 반복
		for(int t = 0; t < K; t++) {
//			if(t == K-3) {
//				for(int i = 0; i < N; i++) {
//					for(int j = 0; j < M; j++) {
//						System.out.print(tower[i][j][0] + " ");
//					}
//					System.out.println();
//				}
//			}
			boolean[][] isAttacked = new boolean[N][M];
			// 3.   공격
			// 3-1. 공격자 선정
			int[] offenseTowerXY = getOffenseTowerXY(tower);
			isAttacked[offenseTowerXY[0]][offenseTowerXY[1]] = true;
			
			// 3-2. 공격대상 선정
			int[] defenseTowerXY = getDefenseTowerXY(tower, offenseTowerXY);
			isAttacked[defenseTowerXY[0]][defenseTowerXY[1]] = true;
			
			//		공격자로 선정된 포탑은 N + M만큼의 공격력이 증가한다.
			tower[offenseTowerXY[0]][offenseTowerXY[1]][0] = tower[offenseTowerXY[0]][offenseTowerXY[1]][0] + N + M;
			// 3-3. 레이저 공격
			boolean isLaserAttack = laserAttact(tower, offenseTowerXY, defenseTowerXY, isAttacked);
			
			// 3-4. 포탄 공격
			if(!isLaserAttack) canonAttack(tower, offenseTowerXY, defenseTowerXY, isAttacked);

			// 4.	포탑 부서짐
			//		공격을 받아 공격력이 0이 되면 포탑은 부서진다.
			//		공격 메소드에서 처리
			
			// 5.	포탑 정비
			//		공격이 끝나면 부서지지 않은 포탑 중 공격과 무관했던 포탑은 공격력이 1씩 올라간다.
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(tower[i][j][0] > 0 && !isAttacked[i][j]) tower[i][j][0]++;
					if(tower[i][j][0] > 0) cnt++;
				}
			}
			tower[offenseTowerXY[0]][offenseTowerXY[1]][1] = t + 1;
			
			if(cnt == 1) break;
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				max = Math.max(max, tower[i][j][0]);
			}
		}
		
		System.out.println(max);
		
		
	}

	private static void canonAttack(int[][][] tower, int[] offenseTowerXY, int[] defenseTowerXY, boolean[][] isAttacked) {
		//		공격대상과 주위 8개 방향에 있는 포탑에 피해를 입힌다.
		//		가장자리의 포탑을 공격하면 반대편에 있는 포탑 50% 피해
		//		공격대상은 공격력의 100%, 주위에 있는 포탑은 공격력의 50% 데미지
		
		// 상 우상 우 우하 하 좌하 좌 좌상
		int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
		
		int startX = offenseTowerXY[0];
		int startY = offenseTowerXY[1];
		int targetX = defenseTowerXY[0];
		int targetY = defenseTowerXY[1];
		
		int damage = tower[startX][startY][0];
		
		tower[targetX][targetY][0] = tower[targetX][targetY][0] - damage;
		if(tower[targetX][targetY][0] < 0) {
			tower[targetX][targetY][0] = 0;
			tower[targetX][targetY][1] = -1;
		}
		
		for(int d = 0; d < 8; d++) {
			int nx = (targetX + dx[d] + tower.length) % tower.length;
			int ny = (targetY + dy[d] + tower[0].length) % tower[0].length;
			
			if(tower[nx][ny][0] <= 0 || (nx == startX && ny == startY)) continue;
			
			tower[nx][ny][0] = tower[nx][ny][0] - (damage / 2);
			if(tower[nx][ny][0] < 0) {
				tower[nx][ny][0] = 0;
				tower[nx][ny][1] = -1;
			}
			isAttacked[nx][ny] = true;
		}
		
		
	}

	private static boolean laserAttact(int[][][] tower, int[] offenseTowerXY, int[] defenseTowerXY, boolean[][] isAttacked) {
		//		상하좌우로 움직이고 부서진 포탑 위치는 지나가지 못함
		//		가장자리에서 막힌 방향으로 이동하면 반대편이 나온다
		//		경로가 존재하지 않으면 포탄 공격을 한다
		//		최단 경로가 2개 이상이면 우/하/좌/상 우선순위대로 먼저 움직인 경로가 선택(BFS 탐색을 저 순서로 하면 신경 안써도 될듯)
		//		최단 경로가 정해졌으면 공격당하는 포탑 체력이 공격력만큼 줄어들고 경로에 있는 포탑들은 공격력/2 만큼 줄어든다
		
		// 우 하 좌 상
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int startX = offenseTowerXY[0];
		int startY = offenseTowerXY[1];
		int targetX = defenseTowerXY[0];
		int targetY = defenseTowerXY[1];
		boolean[][] isVisited = new boolean[tower.length][tower[0].length];
		
		Queue<Laser> queue = new ArrayDeque<>();
		List<int[]> tempList = new ArrayList<>();  
		queue.offer(new Laser(startX, startY, 0, tempList));
		isVisited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Laser laser = queue.poll();
			isVisited[laser.x][laser.y] = true;
			for(int d = 0; d < 4; d++) {
				int nx = (laser.x + dx[d] + tower.length) % tower.length;
				int ny = (laser.y + dy[d] + tower[0].length) % tower[0].length;
				if(!isVisited[nx][ny] && tower[nx][ny][0] > 0) {
					if(nx == targetX && ny == targetY) {
						int damage = tower[startX][startY][0];
						tower[targetX][targetY][0] = tower[targetX][targetY][0] - damage;
						if(tower[targetX][targetY][0] < 0) {
							tower[targetX][targetY][0] = 0;
							tower[targetX][targetY][1] = -1;
						}
						
						laser.list.remove(0);
						while(!laser.list.isEmpty()) {
							int prevX = laser.list.get(0)[0];
							int prevY = laser.list.remove(0)[1];
							tower[prevX][prevY][0] = tower[prevX][prevY][0] - (damage / 2);
							if(tower[prevX][prevY][0] < 0) {
								tower[prevX][prevY][0] = 0;
								tower[prevX][prevY][1] = -1;
							}
							isAttacked[prevX][prevY] = true;
						}
						
						return true;
					}
					
					queue.offer(new Laser(nx, ny, laser.cnt + 1, laser.list));
					
				}
			}
		}
		
		return false;
	}

	private static int[] getOffenseTowerXY(int[][][] tower) {
		//		가장 약한 포탑을 선정한다.
		//		같은 우선순위의 포탑이 2개 이상이면
		//		공격력이 가장 낮은 포탑 >가장 최근에 공격한 포탑 > 포탑 위치의 행과 열의 합이 가장 큰 포탑 > 열 값이 가장 큰 포탑
		
		int[] defenseXY = {0, 0};
		int minHp = Integer.MAX_VALUE;
		int minHpCnt = 0;
		for(int i = 0; i < tower.length; i++) {
			for(int j = 0; j < tower[i].length; j++) {
				if(tower[i][j][0] <= 0) continue;
				if(tower[i][j][0] < minHp) {
					defenseXY[0] = i;
					defenseXY[1] = j;
					minHp = tower[i][j][0];
					minHpCnt = 1;
				} else if(tower[i][j][0] == minHp) {
					minHpCnt++;
				}
			}
		}
		
		if(minHpCnt == 1) return defenseXY;
		
		// 같은 우선순위 포탑 2개 이상 / 가장 최근 공격 포탑 선정
		int recentAtk = 0;
		int recentAtkCnt = 0;
		for(int i = 0; i < tower.length; i++) {
			for(int j = 0; j < tower[i].length; j++) {
				if(tower[i][j][0] <= 0 || tower[i][j][0] != minHp) continue;
				if(tower[i][j][1] > recentAtk) {
					defenseXY[0] = i;
					defenseXY[1] = j;
					recentAtk = tower[i][j][1];
					recentAtkCnt = 1;
				} else if(tower[i][j][1] == recentAtk) {
					recentAtkCnt++;
				}
			}
		}
		
		if(recentAtkCnt == 1) return defenseXY;
		
		// 같은 우선순위 포탑 2개 이상 / 포탑 위치의 행과 열의 합이 가장 큰 포탑
		int maxRCSum = 0;
		int maxRCSumCnt = 0;
		for(int i = 0; i < tower.length; i++) {
			for(int j = 0; j < tower[i].length; j++) {
				if(tower[i][j][0] <= 0 || tower[i][j][0] != minHp || tower[i][j][1] != recentAtk) continue;
				int rcSum = i + j;
				if(maxRCSum < rcSum) {
					defenseXY[0] = i;
					defenseXY[1] = j;
					maxRCSum = rcSum;
					maxRCSumCnt = 1;
				} else if (maxRCSum == rcSum) {
					maxRCSumCnt++;
				}
			}
		}
		
		if(maxRCSumCnt == 1) return defenseXY;
		
		// 같은 우선순위 포탑 2개 이상 / 포탑 위치의 열 값이 가장 큰 포탑
		int maxRow = 0;
		for(int i = 0; i < tower.length; i++) {
			for(int j = 0; j < tower[i].length; j++) {
				if(tower[i][j][0] <= 0 || tower[i][j][0] != minHp || tower[i][j][1] != recentAtk || i + j == maxRCSum) continue;
				if(maxRow < j) {
					maxRow = j;
					defenseXY[0] = i;
					defenseXY[1] = j;
				}
			}
		}
		
		return defenseXY;
	}

	private static int[] getDefenseTowerXY(int[][][] tower, int[] offenseTowerXY) {
		//		가장 강한 포탑을 공격한다.
		//		같은 우선순위의 포탑이 2개 이상이면
		//		공격력이 가장 높은 포탑 > 공격한지 가장 오래된 포탑 > 행과 열의 합이 가장 작은 포탑 > 열 값이 가장 작은 포탑
		int[] defenseXY = {0, 0};
		int maxHp = Integer.MIN_VALUE;
		int maxHpCnt = 0;
		for(int i = 0; i < tower.length; i++) {
			for(int j = 0; j < tower[i].length; j++) {
				if((i == offenseTowerXY[0] && j == offenseTowerXY[1]) || tower[i][j][0] <= 0) continue;
				if(tower[i][j][0] > maxHp) {
					defenseXY[0] = i;
					defenseXY[1] = j;
					maxHp = tower[i][j][0];
					maxHpCnt = 1;
				} else if(tower[i][j][0] == maxHp) {
					maxHpCnt++;
				}
			}
		}
		
		if(maxHpCnt == 1) return defenseXY;
		
		// 같은 우선순위 포탑 2개 이상 / 공격한지 가장 오래된 포탑
		int olderAtk = Integer.MAX_VALUE;
		int olderAtkCnt = 0;
		for(int i = 0; i < tower.length; i++) {
			for(int j = 0; j < tower[i].length; j++) {
				if((i == offenseTowerXY[0] && j == offenseTowerXY[1]) || tower[i][j][0] <= 0 || tower[i][j][0] != maxHp) continue;
				if(tower[i][j][1] < olderAtk) {
					defenseXY[0] = i;
					defenseXY[1] = j;
					olderAtk = tower[i][j][1];
					olderAtkCnt = 1;
				} else if(tower[i][j][1] == olderAtk) {
					olderAtkCnt++;
				}
			}
		}
		
		if(olderAtkCnt == 1) return defenseXY;
		
		// 같은 우선순위 포탑 2개 이상 / 행과 열의 합이 가장 작은 포탑 
		int minRCSum = Integer.MAX_VALUE;
		int minRCSumCnt = 0;
		for(int i = 0; i < tower.length; i++) {
			for(int j = 0; j < tower[i].length; j++) {
				if((i == offenseTowerXY[0] && j == offenseTowerXY[1]) || tower[i][j][0] <= 0 || tower[i][j][0] != maxHp || tower[i][j][1] != olderAtk) continue;
				int rcSum = i + j;
				if(minRCSum > rcSum) {
					defenseXY[0] = i;
					defenseXY[1] = j;
					minRCSum = rcSum;
					minRCSumCnt = 1;
				} else if (minRCSum == rcSum) {
					minRCSumCnt++;
				}
			}
		}
		
		if(minRCSumCnt == 1) return defenseXY;
		
		// 같은 우선순위 포탑 2개 이상 / 열 값이 가장 작은 포탑
		int minRow = Integer.MAX_VALUE;
		for(int i = 0; i < tower.length; i++) {
			for(int j = 0; j < tower[i].length; j++) {
				if((i == offenseTowerXY[0] && j == offenseTowerXY[1]) || tower[i][j][0] <= 0 || tower[i][j][0] != maxHp || tower[i][j][1] != olderAtk || i + j != minRCSum) continue;
				if(minRow > j) {
					minRow = j;
					defenseXY[0] = i;
					defenseXY[1] = j;
				}
			}
		}
		
		return defenseXY;
	}
}