package day0811;

import java.io.*;
import java.util.*;

public class Solution_d4_1227_대전_8반_조재형 {
	
	static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1}; // 상 우 하 좌
	static int[][] a;
	static boolean[][] v;
	static int N = 100, ans = 0;
	static boolean find = false;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1227.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++)
		{
			br.readLine();
			
			ans = 0;
			
			a = new int[N][N];
			v = new boolean[N][N];
			int cr = 1;
			int cc = 1;
			
			
			for(int r = 0; r < N; r++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String s = st.nextToken();
				for(int c = 0; c < N; c++)
				{
					a[r][c] = s.charAt(c) - 48;
				}
			}
			dfs(cr, cc);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	static void dfs(int r, int c)
	{
		v[r][c] = true;
		
		for(int d = 0; d < 4; d++)
		{
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && a[nr][nc] != 1)
			{
				if(a[nr][nc] == 3)
				{
					ans = 1;
					return;
				}
				dfs(nr, nc);
			}
			if(find) return;
		}
	}
	
}
