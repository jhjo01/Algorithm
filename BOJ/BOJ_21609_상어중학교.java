package BOJ;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
    구현문제
    1. 크기가 가장 큰 블록 그룹 찾기
            블록 그룹은 같은 색끼리 + 무지개 블록만 가능
        1-1 이런게 여러개면 무지개 블록 수 가 가장 많은 블록 그룹 선택
        1-2 이런게 여러개면 블록의 행이 가장 큰것 선택
        1-3 이런게 여러개면 블록의 열이 가장 큰것 선택
    2. 1에서 찾은 블록을 제거하고 블록의 수의 제곱만큼 점수 획득
    3. 격자에 중력 작용
    4. 격자 반시계 90도 회전
    5. 격자에 중력 작용
 */
public class BOJ_21609_상어중학교 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        boolean find = true;
        while (find) {
            find = false;
            // 크기가 가장 큰 블록 그룹 찾기
            int[][] visited = new int[N][N];
            int group = 1;
            int selectedGroup = 1;

            Queue<int[]> q = new ArrayDeque<>();
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    int cnt = 0;
                    int cnt2 = 0;
                    if (visited[r][c] != 0 || map[r][c] == -1) continue;
                    find =true;

                    q.offer(new int[] {r, c});
                    visited[r][c] = group;
                    int now = map[r][c];
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        int cr = temp[0];
                        int cc = temp[1];

                        for(int d = 0; d < 4; d++) {
                            int nr = cr + dr[d];
                            int nc = cc + dc[d];
                            if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] != 0 ||
                                    (map[nr][nc] != now && map[nr][nc] != 0)) continue;
                            q.offer(new int[] {nr, nc});
                            visited[nr][nc] = group;
                            cnt++;
                        }

                    }
                    group++;
                }
            }

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    System.out.print(visited[r][c] + " ");
                }
                System.out.println();
            }

            int a = 0;


            // 블록 제거 및 점수 추가


            // 중력


            // 90도 회전


            // 중력

        }
    }

    static void gravity() {

    }
}
