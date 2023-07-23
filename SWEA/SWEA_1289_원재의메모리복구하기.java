package com.ssafy.recur;

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
//			int num = sc.nextInt();
			String temp = sc.nextLine();
			int[] target = new int[temp.length()];
			int[] data = new int[target.length];
			
			for(int i = 0; i < temp.length(); i++)
			{
				target[i] = temp.charAt(i) - 48;
			}
			
			
			int cnt = 0;
			for(int i = 0; i < target.length; i++)
			{
				if(target[i] != data[i])
				{
					for(int j = i; j < target.length; j++)
					{
						data[j] = (data[j] + 1) % 2;
					}
					cnt++;
				}
			}
				
			System.out.println("#" + test_case + " " + cnt);
		}

		
	}
}
