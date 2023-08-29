class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int cnt = 1;
            char ch = s.charAt(i);
            
            for(int j = i + 1; j < s.length(); j ++) {
                // System.out.println(ch + " " + s.charAt(j) + " " + cnt);
                if(s.charAt(j) == ch) {
                    cnt++;
                    if(j == s.length() - 1) cnt = 10000;
                    continue;
                } else {
                    cnt--;
                }
                
                if(cnt == 0) {
                    i = j;
                    answer++;
                    break;
                }
                
                if(j == s.length() - 1) cnt = 10000;
            }

            if(cnt != 0) {
                i = i + cnt-1;
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}