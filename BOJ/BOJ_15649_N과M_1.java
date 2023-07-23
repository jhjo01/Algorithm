package day0804;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15649_N과M_1 {
	static int totalCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		
		totalCnt = 0;
		int[] numbers = new int[M];
		boolean[] isSelected = new boolean[N];
		perm(N, M, numbers, isSelected, 0);
		
	}
	
	private static void perm(int N, int M, int[] numbers, boolean[] isSelected, int cnt)
	{
		if(cnt == M)
		{
			totalCnt++;
			for(int i = 0; i < numbers.length; i++)
				System.out.print(numbers[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++)
		{
			if(isSelected[i]) continue;
			// 선택되지 않았다면 수를 사용
			numbers[cnt] = i+1;
			isSelected[i] = true;
			// 다음 수 뽑으러 가기
			perm(N, M, numbers, isSelected, cnt + 1);
			// 사용했던 수에 대한 선택을 되돌리기
			isSelected[i] = false;
		}
	}
}
