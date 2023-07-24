class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // 1. 방향 확인
        // 2. 그 방향쪽에 장애물이 있나 확인
        // 2-1. 장애물이 있으면 continue
        // 2-2. 장애물이 없으면 xy위치 갱신
        
        boolean[][] map = new boolean[park.length][park[0].length()];
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    answer[0] = i;
                    answer[1] = j;
                    map[i][j] = true;
                } else if(park[i].charAt(j) == 'O') {
                    map[i][j] = true;
                }
            }
        }
        
        outer:for(int i = 0; i < routes.length; i++) {
            int nx = 0;
            int ny = 0;
            int distance = routes[i].charAt(2) - 48;
            
            switch (routes[i].charAt(0)) {
                case 'N': {
                    nx = -1;
                    ny = 0;
                    break;
                }
                case 'E': {
                    nx = 0;
                    ny = 1;
                    break;
                }
                case 'S': {
                    nx = 1;
                    ny = 0;
                    break;
                }
                case 'W': {
                    nx = 0;
                    ny = -1;
                    break;
                }
            }
            

            for(int j = 0; j < distance; j++) {
                x = x + nx;
                y = y + ny;
                
                if(x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
                    if(!map[x][y]) {
                        x = answer[0];
                        y = answer[1];
                        continue outer;
                    }
                } else {
                    x = answer[0];
                    y = answer[1];
                    continue outer;
                }
            }
            answer[0] = x;
            answer[1] = y;
        }
        
        return answer;
    }
}