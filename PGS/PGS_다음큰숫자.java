class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int targetCnt = Integer.bitCount(n);
        
        int i = n;
        while(true) {
            i++;
            int cnt = Integer.bitCount(i);
            if(targetCnt == cnt) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}