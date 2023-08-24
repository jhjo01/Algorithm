import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length() - 1; i++) {
            stack.push(s.charAt(i));
        
            while(true) {
                if(stack.size() > 0 && i < s.length() - 1 && stack.peek() == s.charAt(i+1)) {
                    stack.pop();
                    answer++;
                    i++;
                    continue;
                } else if(i == s.length() - 2) {
                    stack.push(s.charAt(i));
                }
                
                break;
            }
        }
        
        answer = stack.size() == 0 && answer > 0 ? 1 : 0;

        return answer;
    }
}