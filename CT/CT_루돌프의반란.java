import java.util.*;

public class Rudolph {
	static int N, M, P, C, D, Rr, Rc;
	static int[][] map;
	static Santa[] santa;
	static int[] dr8 = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc8 = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dr4 = {-1, 0, 1, 0};
	static int[] dc4 = {0, 1, 0, -1};
	
	static class Santa {
		int id, r, c, score, stunCount;
		boolean isStun, isAlive;
		
		public Santa(int id, int r, int c) {
			this.id = id;
			this.r = r;
			this.c = c;
			this.score = 0;
			this.stunCount = 0;
			this.isStun = false;
			this.isAlive = true;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		init(sc);
		
		for(int i = 0; i < M; i++) {
			
			// 루돌프 이동
			moveRudolph();
			
			// 산타 이동
			moveSanta();
			
			
			// 턴 종료
			int count = 0;
			for(int p = 1; p <= P; p++) {
				if(santa[p].isAlive) {
					santa[p].score = santa[p].score + 1;
					count++;
				}
				if(santa[p].isStun) {
					if(santa[p].stunCount <= 0) santa[p].isStun = false;
					else santa[p].stunCount--;
				}
			}
			
			if(count == 0) break;

		}
		
		// 출력
		for(int i = 1; i <= P; i++) {
			System.out.print(santa[i].score + " ");			
		}
	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		P = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		
		map = new int[N][N];
		santa = new Santa[P + 1];
		
		Rr = sc.nextInt() - 1;
		Rc = sc.nextInt() - 1;
		map[Rr][Rc] = -1;
		
		for(int i = 1; i <= P; i++) {
			int id = sc.nextInt();
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			map[r][c] = id;
			santa[id] = new Santa(id, r, c);
		}
	}
	
	static void moveRudolph() {
		int minDist = Integer.MAX_VALUE;
		int minId = 999;
		
		// 가장 가까운 산타 찾기
		for(int i = 1; i <= P; i++) {
			if(!santa[i].isAlive) continue;
			
			int r = santa[i].r;
			int c = santa[i].c;
			
			int dist = (int)Math.pow(Math.abs(Rr - r), 2) + (int)Math.pow(Math.abs(Rc - c), 2);
			
			if(dist < minDist) {
				minDist = dist;
				minId = i;
			} else if(dist == minDist) {
				if(santa[minId].r < r) {
					minDist = dist;
					minId = i;
				} else if(santa[minId].r == r) {
					if(santa[minId].c < c) {
						minDist = dist;
						minId = i;
					}
				}
			}
		}
		

		
		minDist = Integer.MAX_VALUE;
		int minDir = 0;
		
		for(int d = 0; d < 8; d++) {
			int nr = Rr + dr8[d];
			int nc = Rc + dc8[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			int nextDist = (int)Math.pow(Math.abs(nr - santa[minId].r), 2) + (int)Math.pow(Math.abs(nc - santa[minId].c), 2);
			
			if(nextDist < minDist) {
				minDist = nextDist;
				minDir = d;
			}
		}
		
		// 루돌프 이동
		map[Rr][Rc] = 0;
		Rr = Rr + dr8[minDir];
		Rc = Rc + dc8[minDir];
		
		// 이동하려는 자리에 산타가 있는지 검사
		if(map[Rr][Rc] > 0) {
			collisionRudolph(minId, minDir);
		}
		
		map[Rr][Rc] = -1;			
	}
	
	static void collisionRudolph(int id, int dir) {
		int r = santa[id].r;
		int c = santa[id].c;
		int nd = dir;
		santa[id].score = santa[id].score + C;

		// 맵에서 산타 삭제
		map[r][c] = 0;
		
		// 위치 선정
		for(int i = 0; i < C; i++) {
			r = r + dr8[nd];
			c = c + dc8[nd];
		}
		
		// 위치가 맵 밖인지 검사
		if(r < 0 || r >= N || c < 0 || c >= N) {
			santa[id].isAlive = false;
			return;
		}
		
		// 위치에 다른 산타 있는지 검사
		if(map[r][c] > 0) {
			interaction(map[r][c], nd);
		}
		
		santa[id].r = r;
		santa[id].c = c;
		map[r][c] = id;
		santa[id].isStun = true;
		santa[id].stunCount = 1;
	}
	
	static void interaction(int id, int dir) {
		// dir 입력은 dr8 기준으로 받음
		int r = santa[id].r;
		int c = santa[id].c;
		
		map[r][c] = 0;
		
		r = r + dr8[dir];
		c = c + dc8[dir];

		// 위치가 맵 밖인지 검사
		if(r < 0 || r >= N || c < 0 || c >= N) {
			santa[id].isAlive = false;
			return;
		}
		
		// 위치에 다른 산타 있는지 검사
		if(map[r][c] > 0) {
			interaction(map[r][c], dir);
		}
		
		santa[id].r = r;
		santa[id].c = c;
		map[r][c] = id;
	}

	static void moveSanta() {
		for(int i = 1; i <= P; i++) {
			if(!santa[i].isAlive || santa[i].isStun) continue;
			
			int r = santa[i].r;
			int c = santa[i].c;
			
			int minDist = (int)Math.pow(Math.abs(Rr - r), 2) + (int)Math.pow(Math.abs(Rc - c), 2);
			int minR = r;
			int minC = c;
			int minDir = 0;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr4[d];
				int nc = c + dc4[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > 0) continue;
				
				int nDist = (int)Math.pow(Math.abs(Rr - nr) ,2) + (int)Math.pow(Math.abs(Rc - nc) ,2); 
				if(minDist > nDist) {
					minDist = nDist;
					minR = nr;
					minC = nc;
					minDir = d;
				}
			}
			
			if(minR == r && minC == c || map[minR][minC] > 0) continue;
			
			map[r][c] = 0;
			santa[i].r = minR;
			santa[i].c = minC;
			
			if(map[minR][minC] < 0) {
				collisionSanta(i, minDir);
			} else {
				map[minR][minC] = i;
			}

		}
	}

	static void collisionSanta(int id, int dir) {
		int r = santa[id].r;
		int c = santa[id].c;
		int nd = (dir + 2) % 4;
		santa[id].score = santa[id].score + D;
		
		// 위치 선정
		for(int i = 0; i < D; i++) {
			r = r + dr4[nd];
			c = c + dc4[nd];
		}
		
		// 위치가 맵 밖인지 검사
		if(r < 0 || r >= N || c < 0 || c >= N) {
			santa[id].isAlive = false;
			return;
		}
		
		// 위치에 다른 산타 있는지 검사
		if(map[r][c] > 0) {
			interaction(map[r][c], nd * 2);
		}
		
		santa[id].r = r;
		santa[id].c = c;
		map[r][c] = id;
		santa[id].isStun = true;
		santa[id].stunCount = 1;		
	}
	

}

// N x N 크기의 게임판
// M번의 턴에 걸쳐 진행
// 매 턴마다 루돌프와 산타들이 한 번씩 움짐임
// 루돌프가 1번 움직인 뒤 1번부터 P번까지 산타가 순서대로 움직임
// 기절해있거나 격자 밖으로 빠져나가 탈락한 산타는 못움직임
// 두 칸 사이의 거리는 유클리디안 거리

// 1. 루돌프의 움직임
// 루돌프는 가장 가까운 산타를 향해 1칸 돌진 // 단, 게임에서 탈락한 산타 제외
// 가까운 산타가 여러명이면 r좌표가 큰거, r좌표 동일하면 c좌표가 큰거로 돌진
// 루돌프는 8방향으로 돌진 가능. 우선 순위가 가장 높은 산타를 향해 가장 가까워지는 방향으로 돌진

// 2. 산타의 움직임
// 산타는 1번부터 P번까지 순서대로 움직임
// 기절 or 탈락한 산타는 못움직임
// 산타는 루돌프에게 거리가 가장 가까워지는 방향으로 1칸 이동
// 산타는 다른 산타가 있는 칸이나 게임판 밖으로 이동 불가
// 움직일 수 있는 칸이 없다면 움직이지 않음
// 움직일 수 있더라도 루돌프에게 가까워지는 방법이 없으면 움직이지 않음
// 산타는 4방향으로 움직일 수 있음
// 가까운 방향이 여러개면 상 하 좌 우 우선순위

// 3. 충돌
// 산타와 루돌프가 같은 칸에 있게 되면 충돌 발생
// 루돌프가 움직여서 충돌이 일어난 경우 산타는 C 만큼 점수 얻고 루돌프가 이동해온 방향으로 C칸만큼 밀려남
// 산타가 움직여서 충돌이 일어난 경우 D만큼 점수 얻고 산타가 이동한 방향 반대로 D칸만큼 밀려남
// 밀려난 칸에 다른 산타가 있으면 상호작용 발생

// 4. 상호작용
// 착지하는 칸에 산타가 있으면 그 산타는 한칸 밀려남
// 옆에 또 있으면 연쇄적으로 1칸씩 밀려남

// 5. 기절
// 산타는 루돌프와 충돌 후 1턴간 기절
// 움직일 수 없고 충돌이나 상호작용으로 밀려나는건 가능
// 루돌프는 기절한 산타를 돌진 대상으로 선택 가능

// 6. 게임 종료
// M번의 턴이 끝나거나 산타가 모두 탈락하면 게임종료
// 매 턴 이후 아직 탈락하지 않은 산타들에게 1점씩 추가로 부여



