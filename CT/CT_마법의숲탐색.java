import java.util.*;

public class MagicalForestExploration {
	static int R, C, K, score;
	static int[][] spirits, map;
	static Golem[] golemArray;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Golem {
		int r, c, ur, uc, lr, lc, rr, rc, dr, dc, er, ec, eDir;
		
		public Golem(int r, int c, int eDir) {
			moveGolem(r, c);
			this.eDir = eDir;
		}
		
		public void moveGolem(int r, int c) {
			this.r = r;
			this.c = c;
			
			ur = r - 1;
			uc = c;
			
			lr = r;
			lc = c - 1;
			
			rr = r;
			rc = c + 1;
			
			dr = r + 1;
			dc = c;
		}
		
		public int[] getExit() {
			switch (eDir) {
			case 0:
				return new int[] {ur, uc};
			case 1:
				return new int[] {rr, rc};
			case 2:
				return new int[] {dr, dc};
			default:
				return new int[] {lr, lc};
			}
		}
	}

	public static void main(String[] args) {
		
		//1. 입력
		//2. 골렘 투입
		//2-1. 골렘은 남쪽으로 내려간다
		//2-2. 남쪽이 막혀있으면 서쪽으로 회전하고 내려간다
		//2-3. 서쪽이 막혀있으면 동쪽으로 회전하고 내려간다
		//2-4. 내려갈 수 없을 때까지 반복
		//3. 정령 이동
		//3-1. 정령은 골렘의 출구로 나가야한다
		//3-2. 출구에 다른 골렘이 있으면 타고 나갈 수 있다
		//3-3. 도달할 수 있는 가장 남쪽 칸으로 이동
		//3-4. 정령의 위치를 점수에 추가
		//4. 위 과정 반복
		//4-1. 새로운 골렘을 투입하는데 골렘이 격자 안으로 못들어가면 그 골렘은 삭제시키고 맵 초기화
		
		// 필요한 구현
		// 골렘 클래스
		// 골렘 이동 함수
		// 정령 이동 함수
		
		init();
		deployGolem(spirits[1][0], 1);
		moveLeft(1);
		for(int t = 1; t <= K; t++) {
			boolean canDeploy = false;
			deployGolem(spirits[t][0], t);
			while(true) {
				// 가장 아래에 도달
				if(golemArray[t].r == R - 2) {
					map[golemArray[t].r][golemArray[t].c] = t;
					for(int d = 0; d < 4; d++) {
						map[golemArray[t].r + dr[d]][golemArray[t].c + dc[d]] = t;
					}
					canDeploy = true;
					break;
				}
				
				if(moveDown(t)) continue;
				if(moveLeft(t)) continue;
				if(moveRight(t)) continue;
				
				// 더이상 못내려감
				if(golemArray[t].r < 1) break;
				map[golemArray[t].r][golemArray[t].c] = t;
				for(int d = 0; d < 4; d++) {
					map[golemArray[t].r + dr[d]][golemArray[t].c + dc[d]] = t;
					canDeploy = true;
				}
				break;
			}
			
			if(!canDeploy) {
				// 맵에 골렘 배치 불가능
				// clear map
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						map[i][j] = 0;
					}
				}
				continue;
			}
			
			moveSpirit(golemArray[t].r, golemArray[t].c);
			
		}
		
		System.out.println(score);

	}
	
	private static void moveSpirit(int r1, int c1) {
		boolean visited[][] = new boolean[R][C];
		
		visited[r1][c1] = true;
		for(int d = 0; d < 4; d++) {
			int nr = r1 + dr[d];
			int nc = c1 + dc[d];
			visited[nr][nc] = true;
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(golemArray[map[r1][c1]].getExit());
		int maxScore = golemArray[map[r1][c1]].dr;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			if(maxScore < golemArray[map[r][c]].dr) maxScore = golemArray[map[r][c]].dr;
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] <= 0 || visited[nr][nc]) continue;
				
				queue.offer(golemArray[map[nr][nc]].getExit());
				visited[nr][nc] = true;
			
				int r2 = golemArray[map[nr][nc]].r;
				int c2 = golemArray[map[nr][nc]].c;
				visited[r2][c2] = true;
				for(int i = 0; i < 4; i++) {
					int tr = r2 + dr[d];
					int tc = c2 + dc[d];
					visited[tr][tc] = true;
				}
			}
		}
		score = score + maxScore + 1;
		System.out.println(maxScore + 1);
	}

	private static boolean moveDown(int no) {
		int[] dr = {1, 2, 1};
		int[] dc = {-1, 0, 1};
		Golem golem = golemArray[no];
		
		for(int d = 0; d < dr.length; d++) {
			int nr = golem.r + dr[d];
			int nc = golem.c + dc[d];
			if(nc < 0 || nc >= C) return false;
			if(nr >= 0 && map[nr][nc] > 0) return false;
		}
		
		golem.moveGolem(golem.r + 1, golem.c);
		
		return true;
	}

	private static boolean moveLeft(int no) {
		int[] dr = {-1, 0, 1, 1, 2};
		int[] dc = {-1, -2, -1, -2, -1};
		Golem golem = golemArray[no];
		
		for(int d = 0; d < dr.length; d++) {
			int nr = golem.r + dr[d];
			int nc = golem.c + dc[d];
			if(nc < 0 || nc >= C) return false;
			if(nr >= 0 && map[nr][nc] > 0) return false;
		}
		
		// 0 > 3 > 2 > 1
		// (n + 3) % 4
		// (0 + 3) % 4 = 3;
		// (3 + 3) % 4 = 2;
		// (2 + 3) % 4 = 1;
		// (1 + 3) % 4 = 0;
		golem.eDir = (golem.eDir + 3) % 4;
		golem.moveGolem(golem.r + 1, golem.c - 1);
		return true;
	}

	private static boolean moveRight(int no) {
		int[] dr = {-1, 0, 1, 1, 2};
		int[] dc = {1, 2, 1, 2, 1};
		Golem golem = golemArray[no];
		
		for(int d = 0; d < dr.length; d++) {
			int nr = golem.r + dr[d];
			int nc = golem.c + dc[d];
			if(nc < 0 || nc >= C) return false;
			if(nr >= 0 && map[nr][nc] > 0) return false;
		}
		
		// 0 > 1 > 2 > 3
		// (n + 1) % 4
		// (0 + 1) % 4 = 1;
		// (1 + 1) % 4 = 2;
		// (2 + 1) % 4 = 3;
		// (3 + 1) % 4 = 0;
		golem.eDir = (golem.eDir + 1) % 4;
		golem.moveGolem(golem.r + 1, golem.c + 1);
		
		return true;
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		spirits = new int[K + 1][2];
		map = new int[R][C];
		score = 0;
		golemArray = new Golem[K + 1];
		
		for(int i = 1; i <= K; i++) {
			spirits[i][0] = sc.nextInt() - 1;			
			spirits[i][1] = sc.nextInt();			
		}
		
		sc.close();
	}

	static boolean deployGolem(int c, int no) {
		// 0,c 1,c-1 1,c 1,c+1 2,c
//		if(map[0][c] > 0 || map[1][c - 1] > 0 || map[1][c] > 0 || map[1][c + 1] > 0 || map[2][c] > 0) return false;
		golemArray[no] = new Golem(-2, c, spirits[no][1]);
		return true;
	}
}
