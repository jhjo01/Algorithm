package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static char[][] map;
	static int ans, N, M;
	static boolean complete;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int r = 0; r < N; r++)
		{
			String s = bf.readLine();
			for(int c = 0; c < M; c++)
			{
				map[r][c] = s.charAt(c); 
			}
		}
		
		ans = 0;
		for(int i = 0; i < N; i++)
		{
			complete = false;
			solve(i, 0);	
		}
		
		System.out.println(ans);
		
		
	}
	
	static void solve(int cr, int cc)
	{
		map[cr][cc] = 'x';
		
		for(int r = 0; r < N; r++)
		{
			for(int c = 0; c < M; c++)
			{
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		if(cc >= M-1)
		{
			ans++;
			complete = true;
			return;
		}
		
		for(int i = 0; i < 3; i++)
		{
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			
			if(nc >= 0 && nc < M && nr >= 0 && nr < N && map[nr][nc] != 'x')
			{
				solve(nr, nc);
				if(complete) return;
			}
		}
		
		
	}
}

// 오른쪽, 오른쪽 위, 오른쪽 아래