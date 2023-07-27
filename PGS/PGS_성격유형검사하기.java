import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        char[] c = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 8; i++) {
            map.put(c[i], 0);
        }
        
        
        for(int i = 0; i < survey.length; i++) {
            if(choices[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + (4 - choices[i]));
            } else if(choices[i] > 4) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + (choices[i] - 4));
            }  
        }
        
        if(map.get('R') < map.get('T')) answer = answer + "T";
        else answer = answer + "R";
        
        if(map.get('C') < map.get('F')) answer = answer + "F";
        else answer = answer + "C";
            
        if(map.get('J') < map.get('M')) answer = answer + "M";
        else answer = answer + "J";
            
        if(map.get('A') < map.get('N')) answer = answer + "N";
        else answer = answer + "A";
       
        return answer;
    }
}