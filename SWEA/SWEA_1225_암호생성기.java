package day0804;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			Queue<Integer> Arr = new LinkedList<>();
			
			for(int i = 0; i < 8; i++)
			{
				Arr.add(sc.nextInt());
			}
			
			boolean a = true;
			while(a)
			{
				for(int i = 1; i < 6; i++)
				{
					if(Arr.peek() < 50)
						N = 0;
					if(Arr.peek()-i <= 0)
					{
						a = false;
						Arr.add(Arr.poll() - i);
						break;
					}
					Arr.add(Arr.poll() - i);
				}
			}
			
			
			System.out.print("#" + test_case + " " );
			
			for(int i = 1; i < 8; i++)
			{
				System.out.print(Arr.poll() + " ");
			}
			System.out.print(0);
			System.out.println();
			
			
		}
	}
}
