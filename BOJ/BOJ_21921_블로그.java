import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int max = 0;
        int cnt = 0;
        int sum = 0;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] =  sc.nextInt();
        }

        for(int i = 0; i < x; i++) {
            sum =  sum + arr[i];
        }

        max = sum;
        cnt = 1;

        for(int i = x; i < n; i++) {
            sum = sum - arr[i - x];
            sum = sum + arr[i];

            if(max < sum) {
                max = sum;
                cnt = 1;
            } else if(max == sum) {
                cnt++;
            }
        }

        System.out.println( max > 0 ? max + "\n" + cnt : "SAD");


    }

}