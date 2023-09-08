import java.util.*;

public class Main {


    static int n = 19;
    // 우상 우 우하 하
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] map = new int[n][n];
        int ax = 0;
        int ay = 0;
        int ac = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        outer : for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int x = i;
                int y = j;
                int color = map[x][y];
                if(color == 0) continue;

                for(int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int cnt = 1;

                    for(int k = 0; k < 5; k++) {
                        if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == color) {
                            cnt++;
                            nx = nx + dx[d];
                            ny = ny + dy[d];
                            continue;
                        }
                        break;
                    }

                    if(cnt == 5) {
                        int px = x + dx[d] * -1;
                        int py = y + dy[d] * -1;
                        if(!(px >= 0 && px < n && py >= 0 && py < n) || map[px][py] != color) {
                            ax = x + 1;
                            ay = y + 1;
                            ac = color;
                            break outer;
                        }
                    }

                }
            }
        }

        if(ac == 0) {
            System.out.println(ac);
        } else {
            System.out.println(ac);
            System.out.println(ax + " " + ay);
        }



    }



}