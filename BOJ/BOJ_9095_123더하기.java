import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 = 1
        // 1

        // 2 = 2
        // 1+1
        // 2

        // 3 = 4
        // 1+1+1
        // 1+2
        // 2+1
        // 3

        // 4 = 7
        // 1+1+1+1
        // 1+1+2
        // 1+2+1
        // 2+1+1
        // 2+2
        // 1+3
        // 3+1

        // 5 = 13
        // 1+1+1+1+1
        // 1+1+1+2
        // 1+1+2+1
        // 1+2+1+1
        // 2+1+1+1
        // 1+2+2
        // 2+1+2
        // 2+2+1
        // 1+1+3
        // 1+3+1
        // 3+1+1
        // 2+3
        // 3+2

        // n = n-1 + n-2 + n-3

        int N = sc.nextInt();
        for(int tc = 0; tc < N; tc++) {
            int len = sc.nextInt();
            int[] dp = new int[len];

            if(len == 1) {
                System.out.println(1);
            } else if( len == 2) {
                System.out.println(2);
            } else {
                dp[0] = 1;
                dp[1] = 2;
                dp[2] = 4;

                for(int i = 3; i < len; i++) {
                    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
                }

                System.out.println(dp[len-1]);
            }

        }




    }
}