package day0818;

import java.util.Scanner;

public class BOJ_1987_알파벳 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int cnt, ans, N, M;
	static char map[][];
	static String visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		ans = 0;
		visited = "";
		
		for(int r = 0; r < N; r++)
		{
			String s = sc.next();
			for(int c = 0; c < M; c++)
			{
				map[r][c] = s.charAt(c);
			}
		}
		
		
		visited += map[0][0];
		dfs(0, 0, 1);
		
		System.out.println(ans);
	}
	
	public static void dfs(int r, int c, int cnt)
	{
		// 사방탐색
		for(int i = 0; i < 4; i++)
		{
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && 
					(visited.indexOf(map[nr][nc]) == -1)) // 방문하지 않은경우
			{
				String temp = visited;
				visited += map[nr][nc];
				dfs(nr, nc, cnt+1);
				visited = temp;
			}
		}
		ans = Math.max(ans, cnt);
	}
}
