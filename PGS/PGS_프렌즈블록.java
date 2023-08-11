class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            String s = board[i];
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        // 1. 배열 돌면서 0 부터 n-1, m-1 번째까지 본인과 우, 하, 우하가 같은지 확인
        
        // 2. 같으면 boolean map에 true로 변경하면서 cnt 추가
        // 2-1. 변경하면서 boolean 값이 true이면 cnt 추가 안함
        
        // 블록을 아래로 이동
        
        // 1번을 실행했는데 같은게 안나왔으면 종료
        
        int[] dx = {0, 1, 1};
        int[] dy = {1, 1, 0};
        int cnt = 0;
    
        while(true) {
            boolean isDelete = false;
            boolean[][] bMap = new boolean[m][n];
            
            // 1. 배열 돌면서 0 부터 n-1, m-1 번째까지 본인과 우, 하, 우하가 같은지 확인
            for(int x = 0; x < m-1; x++) {
                for(int y = 0; y < n-1; y++) {
                    // 1-1 비어있는 칸이면 continue
                    if(map[x][y] == ' ') continue;
                    boolean isSame = true;
                    for(int d = 0; d < 3; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(!(map[x][y] == map[nx][ny])) {
                            isSame = false;
                            break;
                        }
                    }   
                    
                    // 2. 같으면 boolean map에 true로 변경하면서 cnt 추가
                    if(isSame) {
                        if(!bMap[x][y]) {
                            bMap[x][y] = true;
                            isDelete = true;
                            cnt++;
                        }
                        for(int d = 0; d < 3; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            // 2-1. 변경하면서 boolean 값이 true이면 cnt 추가 안함
                            if(!bMap[nx][ny]) {
                                bMap[nx][ny] = true;
                                cnt++;
                            }
                        }
                    }
                }
            }
            
            // true인 애들 공백으로 없애기
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(bMap[i][j]) map[i][j] = ' ';
                }
            }
            
            // 칸이 비어있으면 위에 있는 블록을 끌어온다
            for(int i = m-1; i >= 0; i--) {
                for(int j = 0; j < n; j++) {
                    // 칸이 비었음
                    if(map[i][j] == ' ') {
                        // 위로 올라가면서 블록이 있는 칸 찾기
                        for(int k = i; k >= 0; k--) {
                            // 블록이 있는 칸이면 비어있는 칸과 swap
                            if(map[k][j] != ' ') {
                                map[i][j] = map[k][j];
                                map[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
            
            // 1번을 실행했는데 같은게 안나왔으면 종료
            if(!isDelete) break;
        }
        
        answer = cnt;
        
        return answer;
    }
}