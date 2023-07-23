import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            queue.offer(new int[] {progresses[i], speeds[i]});
        }
        
        while(!queue.isEmpty()) {
            for(int i = 0, len = queue.size(); i < len; i++) {
                int[] temp = queue.poll();
                int pro = temp[0];
                int spd = temp[1];
                queue.offer(new int[] {pro+spd, spd});
            }
            
            int cnt = 0;
            while(!queue.isEmpty() && queue.peek()[0] > 99) {
                queue.poll();
                cnt++;
            }
            
            if(cnt > 0) {
                queue2.offer(cnt);
            }
        }
        
        
        int[] answer = new int[queue2.size()];
        
        for(int i = 0, len = queue2.size(); i < len; i++) {
            answer[i] = queue2.poll();
        }
        
        return answer;
    }
}