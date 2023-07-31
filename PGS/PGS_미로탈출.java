import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        int answer = -1;
        
        boolean[][] originalMap = new boolean[maps.length][maps[0].length()];
        boolean[][] map = new boolean[maps.length][maps[0].length()];
        
        int startX = 0;
        int startY = 0;
        
        int targetX = 0;
        int targetY = 0;
        
        int lockX = 0;
        int lockY = 0;
        
        boolean findKey = false;
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                switch(maps[i].charAt(j)) {
                    case 'S': {
                        startX = i;
                        startY = j;
                        map[i][j] = true;
                        originalMap[i][j] = true;
                        break;
                    }
                    case 'L': {
                        lockX = i;
                        lockY = j;
                        map[i][j] = true;
                        originalMap[i][j] = true;
                        break;
                    }
                    case  'E': {
                        targetX = i;
                        targetY = j;
                        map[i][j] = true;
                        originalMap[i][j] = true;
                        break;
                    }
                    case 'O': {
                        map[i][j] = true;
                        originalMap[i][j] = true;
                        break;
                    }
                    case 'X': {
                        map[i][j] = false;
                        originalMap[i][j] = false;
                        break;
                    }
                }
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {startX, startY, 0});
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            if(!findKey && temp[0] == lockX && temp[1] == lockY) {
                findKey = true;
                queue = new ArrayDeque<>();
                queue.offer(new int[] {temp[0], temp[1], temp[2]});
                break;
            }
            
            for(int d = 0; d < 4; d++) {
                int nx = temp[0] + dx[d];
                int ny = temp[1] + dy[d];
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny]) {
                    queue.offer(new int[] {nx, ny, temp[2] + 1});
                    map[nx][ny] = false;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            if(temp[0] == targetX && temp[1] == targetY) {
                answer = temp[2];
                break;
            }
            
            for(int d = 0; d < 4; d++) {
                int nx = temp[0] + dx[d];
                int ny = temp[1] + dy[d];
                if(nx >= 0 && nx < originalMap.length && ny >= 0 && ny < originalMap[0].length && originalMap[nx][ny]) {
                    queue.offer(new int[] {nx, ny, temp[2] + 1});
                    originalMap[nx][ny] = false;
                }
            }
        }
        
        
        return answer;
    }
}