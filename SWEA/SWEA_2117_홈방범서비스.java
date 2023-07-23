package day0822;

import java.io.*;
import java.util.*;

public class SWEA_2117_홈방범서비스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = N; // 서비스 영역 반지름
			int[][] map = new int[N][N];
			
			for(int r = 0; r < N; r++)
			{
				for(int c = 0; c < N; c++)
				{
					map[r][c] = sc.nextInt();
				}
			}
			
//			for(int[] a:map) System.out.println(Arrays.toString(a));
			
			int max = 0;

			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					for(int k = 0; k <= K; k++)
					{
						int cnt = 0;
						for(int r = i-k-1; r <= i+k; r++)
						{
							if(r < 0 || N <= r) continue;
							for(int c = j-k-1; c < j+k; c++)
							{
								if( c < 0 || N <= c) continue;
								if(Math.abs(r-i) + Math.abs(c-j) > k) continue;
//								if(map[r][c] == 1) cnt++;
								cnt += map[r][c];
							}
						}
						if(cnt * M - ((k*k) + (+-1) * (k+1)) >= 0) max = Math.max(max, cnt);
//						if(cnt * M - ((k*k) + (k-1) * (k-1)) >= 0) max = Math.max(max, cnt);
						
					}
				}
			}
			
			
			
			
			
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}
