import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) {
                queue.offer(i);
                stack.push(i);
            }
        }
        
        for(int i = 0, size = queue.size(); i < size; i++) {
            answer = answer + Integer.toString(queue.poll());
        }
        answer = answer + "0";
        for(int i = 0, size = stack.size(); i < size; i++) {
            answer = answer + Integer.toString(stack.pop());
        }
        
        return answer;
    }
}