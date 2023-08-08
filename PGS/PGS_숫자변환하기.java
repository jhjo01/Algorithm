import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        if(x == y) return 0;
        
        // Queue를 이용한 BFS
        Queue<int[]> queue = new ArrayDeque<>();
        // Map을 이용해 이미 도달한 곳인지 확인
        Map<Integer, Integer> map = new HashMap<>();
        
        queue.offer(new int[] {x, 0});

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int nx = temp[0];
            int cnt = temp[1];
            
            // x + n
            if(nx + n == y) {
                answer = cnt + 1;
                break;
            } else if(nx + n < y) {
                if(!map.containsKey(nx + n)) {
                    queue.offer(new int[] {nx + n, cnt + 1});
                    map.put(nx + n, cnt + 1);
                }
            }
            
            // x * 2
            if(nx * 2 == y) {
                answer = cnt + 1;
                break;
            } else if(nx * 2 < y) {
                if(!map.containsKey(nx * 2)) {
                    queue.offer(new int[] {nx * 2, cnt + 1});
                    map.put(nx * 2, cnt + 1);
                }
            }
            
            // x * 3
            if(nx * 3 == y) {
                answer = cnt + 1;
                break;
            } else if(nx * 3 < y) {
                if(!map.containsKey(nx * 3)) {
                    queue.offer(new int[] {nx * 3, cnt + 1});
                    map.put(nx * 3, cnt + 1);
                }
            }
        }
        
        return answer;
    }
}