import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        int answer = -1;
        if(maps[0][0] == 0) return answer;
        
        int n = maps.length;
        int m = maps[0].length;
        
        int startX = 0;
        int startY = 0;
        int targetX = n - 1;
        int targetY =  m - 1;
        
        boolean[][] visited = new boolean[n][m];
        
        // bfs
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startX, startY, 1});
                                                                                                                                                    
        
        outer : while(!queue.isEmpty()) {                             
            int[] temp = queue.poll();
            
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];
            
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx == targetX && ny == targetY) {
                    answer = cnt + 1;
                    return answer;
                }
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny, cnt + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return answer;
    }
}