package day0812;

import java.io.*;
import java.util.*;

public class SWEA_1953_탈주범검거 {
	
	static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1}; // 상 우 하 좌
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{
			
			N = sc.nextInt();
			M = sc.nextInt();
			int cr = sc.nextInt();
			int cc = sc.nextInt();
			int L = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			
			
			
			for(int r = 0; r < N; r++)
			{
				for(int c = 0; c < N; c++)
				{
					map[r][c] = sc.nextInt();
				}
			}
			dfs(cr, cc, L);
		}
		
	}
	
	static void dfs(int r, int c, int cnt)
	{
		if(cnt == 0) return;
		
		for(int d = 0; d < 4; d++)
		{
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N )
			{
				visited[nr][nc] = true;
				switch(d)
				{
				case 1:
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				}
				dfs(nr, nc, cnt-1);
				visited[nr][nc] = false;
			}
		}
	}
	
	static void move(int d)
	{
		
	}
}
