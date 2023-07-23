package day0808;

import java.util.Scanner;


public class SWEA_9229_한빈이와SpotMart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] data = new int[N];
			int ans = -1;
			for(int i = 0; i < N; i++)
			{
				data[i] = sc.nextInt();
			}
			
			for(int i = 0; i < N-1; i++)
			{
				for(int j = i+1; j < N; j++)
				{
					if(data[i] + data[j] <= M)
					{
						ans = Math.max(ans, data[i] + data[j]);
					}
				}
			}
			
			System.out.println("#" + test_case + " " +ans);
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
		}
	}
}
