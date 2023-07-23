package day0929;

import java.util.Scanner;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		
		for(int i = 1; i < N; i++) {
			arr[i][0] = arr[i][0] + Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1] = arr[i][1] + Math.min(arr[i-1][0], arr[i-1][2]);
			arr[i][2] = arr[i][2] + Math.min(arr[i-1][0], arr[i-1][1]);
		}
		
		int ans = 1000*1000;
		for(int i = 0; i < 3; i++) {
			ans = Math.min(ans, arr[N-1][i]);
		}
		
		System.out.println(ans);
		
	}	
}
