import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();
        
        if(s.charAt(0) == ')') return false;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(stack.size() == 0 || stack.peekLast() == ')') {
                    return false;
                } else {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));       
        }
        
        answer = stack.size() == 0 ? true : false;

        return answer;
    }
}