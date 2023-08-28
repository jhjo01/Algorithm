import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i <= order.length + 1; i++) {
            if(order[idx] == i) {
                answer++;
                idx++;
                continue;
            }

            while(true) {
                if(idx >= order.length) break;
                if (stack.size() != 0 && order[idx] == stack.peek()) {
                    answer++;
                    idx++;
                    stack.pop();
                    continue;
                }
                break;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}