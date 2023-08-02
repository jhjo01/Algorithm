import java.util.*;

class Solution {
    String[] dow = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int[] thirtyOne = {1, 3, 5, 7, 8, 10, 12};
    int[] thirty= {4, 6, 9, 11};
    public String solution(int a, int b) {
        String answer = "";
        
        int dayCount = b - 1;
        
        // refDay = 1
        // refDow = 5
        
        // 1/20 = WED
        // (5 + (day % 7)) % 7
        // (5 + (20 % 7)) % 7 = (5 + 5) % 7 = 3, dow[3] = "TUE"
        
        // 31
        // 1,3,5,7,8,10,12
        // 30
        // 4,6,9,11
        // 29
        // 2
        
        outer : for(int i = 1; i < a; i++) {
            if(i == 2) {
                dayCount += 29;
                continue;
            }
            for(int j = 0; j < thirtyOne.length; j++) {
                if(i == thirtyOne[j]) {
                    dayCount += 31;
                    continue outer;
                }
            }
            
            for(int j = 0; j < thirty.length; j++) {
                if(i == thirty[j]) {
                    dayCount += 30;
                    break;
                }   
            }
        }
        
        answer = dow[(5 + (dayCount % 7)) % 7];
        
        return answer;
    }
}