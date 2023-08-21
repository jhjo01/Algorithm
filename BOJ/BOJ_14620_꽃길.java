import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] selectedMap;
    static int[][] valueMap;
    static int min;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] map = new int[N][N];
        valueMap = new int[N][N];
        selectedMap = new boolean[N][N];
        min = 3000;


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        for(int i = 1; i < N - 1; i++) {
            for(int j = 1; j < N - 1; j++) {
                int sum = map[i][j];
                for(int d = 0; d < 4; d++) {
                    sum = sum + map[i + dx[d]][j + dy[d]];
                }
                valueMap[i][j] = sum;
            }
        }

        comb(0, 0);

        System.out.println(min);
    }

    static void comb(int cnt, int sum) {
        if(cnt == 3) {
            min = Math.min(sum, min);
            return;
        }
        for(int i = 1; i < valueMap.length - 1; i++) {
            outer : for(int j = 1; j < valueMap.length - 1; j++) {
                for(int d = 0; d < 4; d++) {
                    if(selectedMap[i + dx[d]][j + dy[d]]) continue outer;
                }
                selectedMap[i][j] = true;
                for(int d = 0; d < 4; d++) {
                    selectedMap[i + dx[d]][j + dy[d]] = true;
                }

                comb(cnt + 1, sum + valueMap[i][j]);

                selectedMap[i][j] = false;
                for(int d = 0; d < 4; d++) {
                    selectedMap[i + dx[d]][j + dy[d]] = false;
                }
            }
        }
    }
}