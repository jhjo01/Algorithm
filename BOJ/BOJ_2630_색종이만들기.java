package day0816;

import java.util.Scanner;

public class BOJ_2630_색종이만들기 {
	static int bCnt, wCnt;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		map = new int[N][N];
		
		for(int r = 0; r < N; r++)
		{
			for(int c = 0; c < N; c++)
			{
				map[r][c] = sc.nextInt();
			}
		}
		
		int r = 0;
		int c = 0;
		bCnt = 0;
		wCnt = 0;
		
		crop(r, c, N);
		
		System.out.println(wCnt);
		System.out.println(bCnt);
	}
	
	static void crop(int r, int c, int N)
	{
		int cbCnt = 0;
		int cwCnt = 0;
		int ir = r;
		int ic = c;
		for(int cr = 0; cr < N; cr++)
		{
			ic = c;
			for(int cc = 0; cc < N; cc++)
			{
				if(map[ir][ic] == 0) cwCnt++;
				else cbCnt++;
				ic++;
			}
			ir++;
		}
		if(cwCnt == N*N)
		{
			wCnt++;
			return;
		}
		else if(cbCnt == N*N)
		{
			bCnt++;
			return;
		}
		
		crop(r, c, N/2); // 좌상
		crop(r, c + N/2, N/2); // 우상
		crop(r + N/2, c, N/2); // 좌하
		crop(r + N/2, c + N/2, N/2); // 우하

	}
}
