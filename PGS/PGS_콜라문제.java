class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(true) {
            if(n / a == 0) break;
            answer = answer + n / a * b;
            n = ((n / a) * b) + (n % a);
        }
        
        return answer;
    }
}