import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        boolean[] isPaint = new boolean[n];
        Arrays.fill(isPaint, true);
        for(int i = 0; i < section.length; i++) {
            isPaint[section[i] - 1] = false;
        }
        
        for(int i = 0; i < n; i++) {
            if(isPaint[i]) continue;
            
            for(int j = 0; j < m; j++) {
                if(i+j >= n) continue;
                isPaint[i + j] = true;
            }
            answer++;
            i = i + m - 1;
        }
        
        
        return answer;
    }
}