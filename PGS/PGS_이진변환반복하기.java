class Solution {
    int zeroCount;
    public int[] solution(String s) {
        int[] answer = {};
        
        zeroCount = 0;
        int i = 0;
        while(true) {
            i++;
            s = change(s);
            if(s.equals("1")) {
              break;  
            } 
        }
        
        answer = new int[] {i, zeroCount};
        return answer;
    }
    
    public String change(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') count++;
            else zeroCount++;
        }
        
        return Integer.toBinaryString(count);
    }
}