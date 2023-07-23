class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') answer = answer + c;
            else {
                if(c <= 90) {
                    if(c + n > 90) {
                        answer = answer + (char)((c + n) - 26);
                    } else {
                        answer = answer + (char)(c + n);    
                    }
                } else {
                    if (c + n > 122) {
                        answer = answer + (char)((c + n) - 26);
                    } else {
                        answer = answer + (char)(c + n);    
                    }
                }
            }
        }
        return answer;
    }
}