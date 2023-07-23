package com.ssafy.recur;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
			int[][] map = new int[num][num];
			
//			x+ y+ x- y-
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
			int direction = 0;
			
			int idxX = 0;
			int idxY = 0;
			int cnt = 1;
			int num2 = num;
			int cnt2 = 0;
			int cnt2Use = 0;
			for(int i = 0; i < num * 2 - 1; i++)
			{
				map[idxY][idxX] = cnt;
				for(int j = 0; j < num2-1; j++)
				{
					idxX = idxX + dx[direction];
					idxY = idxY + dy[direction];
					cnt++;
					map[idxY][idxX] = cnt;
				}
				cnt2++;
				if(cnt2Use == 0)
				{
					if(cnt2 == 3)
					{
						num2--;
						cnt2 = 0;
						cnt2Use = 1;
					}
				}
				else if(cnt2Use == 1)
				{
					if(cnt2 == 2)
					{
						num2--;
						cnt2 = 0;
					}
				}
				
				direction++;
				if(direction == 4) direction = 0;
			}
			
			System.out.println("#" + test_case);
			for(int i = 0; i < num; i++)
			{
				for(int j = 0; j < num; j++)
				{
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
			
		}
	}
}
