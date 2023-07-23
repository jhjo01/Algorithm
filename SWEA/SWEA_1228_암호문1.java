package day0808;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1228_암호문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			List<Integer> origin = new ArrayList<>();
			for(int i = 0; i < N; i++)
			{
				origin.add(sc.nextInt());
			}
			
			
			int C = sc.nextInt();

			for(int i = 0; i < C; i++)
			{
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				
				for(int j = 0; j < y; j++)
				{
					origin.add(x, sc.nextInt());
					x++;
				}
			}
			
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 10; i++)
			{
				System.out.print(origin.get(i) + " ");
			}
			System.out.println();
		}
	}
}
