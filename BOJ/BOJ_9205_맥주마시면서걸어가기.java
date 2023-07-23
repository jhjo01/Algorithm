package day1006;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			boolean find = false;
			boolean[] visited = new boolean[N];
			
			int[][] gs25 = new int[N][2];
			
			int hr = sc.nextInt();
			int hc = sc.nextInt();
			
			for(int i = 0; i < N; i++) {
				gs25[i][0] = sc.nextInt();
				gs25[i][1] = sc.nextInt();
			}
			
			int tr = sc.nextInt();
			int tc = sc.nextInt();
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			
			q.offer(new int[] {hr, hc, 20});
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				
				int r = temp[0];
				int c = temp[1];
				int beer = temp[2];
				
				int dist = getDist(r, c, tr, tc);
				if(dist <= beer * 50) {
					find = true;
					break;
				}
				
				
				for(int i = 0; i < N; i++) {
					int gr = gs25[i][0];
					int gc = gs25[i][1];
					
					if(visited[i]) continue;
					
					dist = getDist(r, c, gr, gc);
					if(dist <= beer * 50) {
						visited[i] = true;
						q.offer(new int[] {gr, gc, 20});
					}
				}
			}
			System.out.println(find ? "happy" : "sad");
		}
	}
	
	static int getDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
