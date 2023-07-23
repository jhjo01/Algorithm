import java.util.*;
import java.io.ByteArrayInputStream;

class Solution {
    public String solution(String s) {
        
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()) {
            int num = sc.nextInt();
            min = Integer.min(min, num);
            max = Integer.max(max, num);
        }

        String answer = min + " " + max;
        return answer;
    }
}