package BOJ;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1194_달차가 {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    // (dir + 2) % 4 직전에 온 방향

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][][] visited = new boolean[7][N][M];
        char[][] map = new char[N][M];

        int mr = 0;
        int mc = 0;

        for (int r = 0; r < N; r++) {
            String s = sc.next();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c);
                if (map[r][c] == '0') {
                    mr = r;
                    mc = c;
                    map[r][c] = '.';
                }
            }
        }

        int ans = -1;

        Queue<int[]> q = new ArrayDeque<int[]>();

        q.offer(new int[] { mr, mc, -1, 0, 63, 63, 63, 63, 63, 63});

        outer : while(!q.isEmpty()) {
            int[] temp = q.poll();







            int r = temp[0];
            int c = temp[1];
            int prevDir = (temp[2] + 2) % 4;
            if(temp[2] == -1) {
                prevDir = -1;
            }

            int cnt = temp[3];

            // 소유한 키
            char[] keys = new char[6];
            char[] nKeys = new char[6];

            int vCnt = 0;
            for(int i = 0; i < 6; i++) {
                if(temp[i+4] != 63) vCnt++;
            }

            System.out.println();
//           0123456789
//         0 ...#a#....
//         1 ####.#####
//         2 .b..0.AB.1
//         3 ##########
//         4 ..........

//            if(visited[vCnt][r][c]) continue;

            int nr;
            int nc;
            for(int d = 0; d < 4; d++) {
//				if(prevDir == d) continue;
                nr = r + dr[d];
                nc = c + dc[d];

                if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1 || map[nr][nc] == '#') continue;


                if(map[nr][nc] >= 97) {
                    for(int i = 0; i < 6; i++) {
                        nKeys[i] = (char) temp[i+4];
                    }

                    if(nKeys[map[nr][nc] - 97] == 63) {
                        nKeys[map[nr][nc] - 97] = map[nr][nc];
//                    map[nr][nc] = '.';

                        visited[vCnt][nr][nc] = true;
                        q.offer(new int[]{nr, nc, -1, cnt + 1, nKeys[0], nKeys[1], nKeys[2], nKeys[3], nKeys[4], nKeys[5]});
                    }
                    else {
                        visited[vCnt][nr][nc] = true;
                        q.offer(new int[]{nr, nc, -1, cnt + 1, nKeys[0], nKeys[1], nKeys[2], nKeys[3], nKeys[4], nKeys[5]});
                    }
                }


                if(visited[vCnt][nr][nc]) continue;

                if(map[nr][nc] == '1') {
                    ans = cnt + 1;
                    break outer;
                }

                for(int i = 0; i < 6; i++) {
                    keys[i] = (char) temp[i+4];
                }

                if(map[nr][nc] != '.' && map[nr][nc] < 97) {
                    for(int i = 0; i < 6; i++) {
                        if(map[nr][nc]+32 == keys[i]) {
                            visited[vCnt][r][c] = true;
                            q.offer(new int[] {nr, nc, d, cnt+1, keys[0], keys[1], keys[2], keys[3], keys[4], keys[5]});
                            continue;
                        }
                    }
                    continue;
                }




                else {
                    visited[vCnt][r][c] = true;
                    q.offer(new int[] {nr, nc, d, cnt+1, keys[0], keys[1], keys[2], keys[3], keys[4], keys[5]});
                }

            }
        }

        System.out.println(ans);










    }
}
