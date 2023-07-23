package SWEA;

import java.util.Scanner;

public class SWEA_3307_최장증가부분수열 {
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
            int[] data = new int[N];

            for (int i = 0; i < N; i++) {
                data[i] = sc.nextInt();
            }

            int[] dp = new int[N];

            int max = 0;

            for (int i = N-1; i >= 0; i--) {
                int cnt = 0;
                for (int j = i; j < N; j++) {
                    if(data[i] < data[j] && dp[j] >= cnt) {
                        cnt = dp[j] + 1;
                    }
                }
                dp[i] = cnt == 0 ? 1 : cnt;
                max = Math.max(max, dp[i]);
            }

            System.out.println("#" + test_case + " " + max);

        }
    }
}
