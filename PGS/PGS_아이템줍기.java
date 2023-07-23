package PGS;

import java.util.*;

public class PGS_아이템줍기 {
    public static void main(String[] args) {

        int[][] rec = new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int cx = 1;
        int cy = 3;
        int ix = 6;
        int iy = 6;

        int res = solution(rec, cx, cy, ix, iy);

        System.out.println(res);
    }

    static int[] dx = new int[] {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = new int[] {0, 1, 0, -1, -1, 1, -1, 1};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        // map
        int endXY = 51*2;
        int[][] map = new int[endXY][endXY];

        // map init
        // 0은 안겹치는 영역, 1은 테두리, -1은 겹치는 영역
        for(int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;

            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map.length; j++) {
                boolean isZero = false;
                if(map[i][j] == 0) continue;
                for(int d = 0; d < 8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if( nx >= 0 && nx < endXY && ny >= 0 && ny < endXY && map[nx][ny] == 0) {
                        isZero = true;
                        continue;
                    }
                }
                if(isZero) map[i][j] = 1;
                else map[i][j] = 2;

            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {characterX*2, characterY*2, 0});
        map[characterX][characterY] = 0;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];

            // 종료조건 검사
            if(itemX*2 == x && itemY*2 == y) {
                answer = cnt/2;
                break;
            }

            for(int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx > 0 && nx < endXY && ny > 0 && ny < endXY && map[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny, cnt+1});
                    map[nx][ny] = 0;
                }
            }

        }


        return answer;
    }


}
