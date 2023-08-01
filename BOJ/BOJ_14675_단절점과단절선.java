import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < 2; j++) {
                int node = sc.nextInt();
                arr[node] = arr[node] + 1;
            }
        }

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            if(sc.nextInt() == 2) {
                System.out.println("yes");
                sc.nextInt();
            } else {
                if(arr[sc.nextInt()] > 1) System.out.println("yes");
                else System.out.println("no");
            }
        }

    }
}