import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        
        for(int i = 2; i <= n; i++) {
            int num = i; 
            for(int j = 0; j <= n; j++) {
                num = num + i;
                if(num > n) break;
                arr[num] = false;
            }
        }
        
        for(int i = 2; i <= n; i++) {
            if(arr[i]) answer++;
        }
    
        
        
        return answer;
    }
}