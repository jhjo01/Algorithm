import java.util.*;

public class Main {
	static int N, res;
	static int[][] map, costMap;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 1;
		
		while(true) {
			// 1. 입력
			if(init(sc)) break;
			
			// 2. BFS
			bfs();
			
			System.out.println("Problem " + n++ + ": " + res);			
		}
		
		sc.close();
	}



	static boolean init(Scanner sc) {
		N = sc.nextInt();
		if(N == 0) return true;
		map = new int[N][N];
		costMap = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				costMap[i][j] = Integer.MAX_VALUE;
			}
		}
		
		costMap[0][0] = map[0][0];
			
		return false;
	}

	static void bfs() {		
		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] {0, 0, map[0][0]});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(costMap[nr][nc] > costMap[r][c] + map[nr][nc]) {
					costMap[nr][nc] = costMap[r][c] + map[nr][nc];
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
		res = costMap[N-1][N-1];
	}
}



