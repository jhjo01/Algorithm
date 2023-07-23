package day0811;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2961_도영이가만든맛있는음식 {
	static int N, min = 999999;
	static boolean[] isSelected;
	static int[][] data;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		N = sc.nextInt();
		data = new int[N][2];
		
		for(int i = 0; i < N; i++)
		{
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}
		
		isSelected = new boolean[N];
		
		subset(0);
		
		System.out.println(min);
	}
		
		
	private static void subset(int index) // cnt : 직전까지 고려한 원소 수
	{
		if(index == N) // 더이상 고려할 원소가 없다면 부분집합의 구성이 완성 
		{
			int sour = 1;
			int bitters = 0;
			for (int i = 0; i < N; i++)
			{
				if(isSelected[i])
				{
					sour = sour * data[i][0];
					bitters = bitters + data[i][1];
					min = Math.min(min, Math.abs(sour - bitters));
				}
			}	
			
			return;
		}
		
		// 원소 선택
		isSelected[index] = true;
		subset(index + 1);
		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1);
	}
}
