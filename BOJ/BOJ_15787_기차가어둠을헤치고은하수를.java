import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();


        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] map = new boolean[N][20];

        for(int i = 0; i < M; i++) {
            int cmd = sc.nextInt(); // 명령번호
            int train = sc.nextInt() - 1; // 기차번호
            int x = cmd == 1 || cmd == 2 ? sc.nextInt() - 1 : 0; // 좌석번호

            switch (cmd) {
                case 1: {
                    map[train][x] = true;
                    break;
                }
                case 2 : {
                    map[train][x] = false;
                    break;
                }
                case 3: {
                    for(int j = map[train].length - 1; j >= 0 ; j--) {
                        if(map[train][j]) {
                            // 20번째에 사람 앉아있으면 내리기
                            if(j == map[train].length - 1) map[train][j] = false;
                            else {
                                // 20번째 아니면 한칸 뒤로
                                map[train][j] = false;
                                map[train][j + 1] = true;
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    for(int j = 0; j < map[train].length; j++) {
                        if(map[train][j]) {
                            // 0번째에 사람 앉아있으면 내리기
                            if(j == 0) map[train][j] = false;
                            else {
                                // 0번째 아니면 한칸 앞으로
                                map[train][j] = false;
                                map[train][j - 1] = true;
                            }
                        }
                    }
                    break;
                }
            }
        }

        // 명령 다 끝나고 set에 기차 집어넣기
        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j]) sb.append("1");
                else sb.append("0");
            }

            String s = sb.toString();
            set.add(s);
        }


        System.out.println(set.size());


    }
}