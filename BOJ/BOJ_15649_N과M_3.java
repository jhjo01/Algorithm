package day0804;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15649_N과M_3 {
	static int totalCnt;
	static int[][] arr;
	static int arrIdx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[(int)Math.pow(N, M)][];
		arrIdx = 0;
		totalCnt = 0;
		int[] numbers = new int[M];
		boolean[] isSelected = new boolean[N];
		perm(N, M, numbers, isSelected, 0);
		
		for(int i = 0; i < (int)Math.pow(N, M); i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void perm(int N, int M, int[] numbers, boolean[] isSelected, int cnt)
	{
		if(cnt == M)
		{
			totalCnt++;
			arr[arrIdx] = numbers.clone();
			arrIdx++;
			
			return;
		}
		
		for(int i = 0; i < N; i++)
		{
			if(isSelected[i]) continue;
			numbers[cnt] = i+1;
			//isSelected[i] = true;
			perm(N, M, numbers, isSelected, cnt + 1);
			isSelected[i] = false;
		}
	}
}
