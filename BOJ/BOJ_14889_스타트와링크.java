package BOJ;

import java.util.Scanner;

public class BOJ_14889_스타트와링크 {
    static  int N;
    static boolean visited[];
    static int map[][];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }


    static void dfs(int idx, int n) {
        if(n == N/2) {
            int start = 0;
            int link = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i] && visited[j]) start = start + map[i][j];
                    if(!visited[i] && !visited[j]) link = link + map[i][j];
                }
            }

            ans = Math.min(Math.abs(start-link), ans);

            return;
        }

        for (int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, n+1);
                visited[i] = false;
            }
        }
    }
}
