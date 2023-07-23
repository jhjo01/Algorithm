package BOJ;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1520_내리막길_BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][M];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        int ans = 0;

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {0,0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];

            if(r == N-1 && c == M-1) {
                ans++;
                continue;
            }

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(map[nr][nc] >= map[r][c]) continue;

                q.offer(new int[] {nr, nc});
            }

        }

        System.out.println(ans);
    }
}
