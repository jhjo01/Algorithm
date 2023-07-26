import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if(idx[index] == -1) {
                answer[i] = idx[index];
            } else answer[i] = i - idx[index];
            
            idx[index] = i;
        }
        
        
        return answer;
    }
}