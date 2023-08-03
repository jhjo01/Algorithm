import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int c = sc.nextInt();

        for(int i = 0; i < c; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int remainRound = k - Math.max(m, n);
            if((m >= n && m - remainRound - n > 2) || (m < n && n - remainRound - m > 1)) System.out.println(0);
            else System.out.println(1);
        }
    }
}