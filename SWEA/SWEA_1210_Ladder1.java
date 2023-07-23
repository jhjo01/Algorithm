package com.ssafy.recur;

import java.util.Scanner;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
			
			int[][] map = new int[100][100];
			int startIdxY = 0;
			int startIdxX = 0;
			
			for(int i = 0; i < 100; i++)
			{
				for(int j = 0; j < 100; j++)
				{
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2)
					{
						startIdxY = i;
						startIdxX = j;
					}
				}
			}
			
			int currIdxY = startIdxY;
			int currIdxX = startIdxX;
			
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			// 0 우, 1 좌, 2 하, 3 상
			int direction = 3;
			// 우선순위 좌,우 > 상
			
			while(currIdxY != 0)
			{
				// 왼쪽 이동
				if(currIdxX > 0 && currIdxX < 100 && map[currIdxY][currIdxX - 1] == 1)
				{
					direction = 1;
					while(currIdxX > 0 && map[currIdxY][currIdxX - 1] != 0)
					{
						currIdxX = currIdxX + dx[direction];
						currIdxY = currIdxY + dy[direction];
						map[currIdxY][currIdxX] = 2;
					}
					direction = 3;
					currIdxX = currIdxX + dx[direction];
					currIdxY = currIdxY + dy[direction];
					map[currIdxY][currIdxX] = 2;
				}
				// 오른쪽 이동
				else if(currIdxX >= 0 && currIdxX < 99 && map[currIdxY][currIdxX + 1] == 1)
				{
					direction = 0;
					while(currIdxX < 99 && map[currIdxY][currIdxX + 1] != 0)
					{
						currIdxX = currIdxX + dx[direction];
						currIdxY = currIdxY + dy[direction];
						map[currIdxY][currIdxX] = 2;
					}
					direction = 3;
					currIdxX = currIdxX + dx[direction];
					currIdxY = currIdxY + dy[direction];
					map[currIdxY][currIdxX] = 2;
				}
				// 위로 이동
				else
				{
					currIdxX = currIdxX + dx[direction];
					currIdxY = currIdxY + dy[direction];
					map[currIdxY][currIdxX] = 2;
				}
				
				
				
				if(currIdxY == 0) System.out.println("#" + test_case + " "  + currIdxX);
				
				
				
				
//				for(int i = 0; i < 10; i++)
//				{
//					for(int j = 0; j < 10; j++)
//					{
//						System.out.print(map[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			
		}
	}
}
