import java.util.*;

public class Main {

    static int n;
    static boolean[] isSelectedX, isSelectedY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> tList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        isSelectedX = new boolean[n];
        isSelectedY = new boolean[n];

        char[][] map = new char[n][n];

        tList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String s = sc.nextLine().replace(" ", "");
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'T') {
                    tList.add(new int[] {i, j});
                }
            }
        }

        System.out.println(comb(0, 0, 0, map) ? "YES" : "NO");

    }

    public static boolean comb(int startX, int startY, int cnt, char[][] map) {
        if(cnt == 3) {
            for(int[] pos : tList) {
                int x = pos[0];
                int y = pos[1];

                for(int d = 0; d < 4; d++) {
                    int nx = x;
                    int ny = y;

                    while(true) {
                        nx = nx + dx[d];
                        ny = ny + dy[d];

                        if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if(map[nx][ny] == 'O') break;
                            if(map[nx][ny] == 'S') {
                                return false;
                            }
                            continue;
                        }

                        break;
                    }
                }
            }

            return true;
        }

        for(int i = startX; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    if (isSelectedX[i] && isSelectedY[j]) continue;
                    isSelectedX[i] = isSelectedY[j] = true;
                    map[i][j] = 'O';
                    if (comb(i, j + 1, cnt + 1, map)) return true;
                    map[i][j] = 'X';
                    isSelectedX[i] = isSelectedY[j] = false;
                }
            }
        }

        return false;
    }

}