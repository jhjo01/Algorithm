class Solution {
    public int solution(int n) {
        int answer = 1;
        
        // 투포인터? 슬라이딩윈도우?
        
        int p1 = 1;
        int p2 = 2;
        int sum = 3;
        
        while(p1 + p2 < n + 1) {
            if(sum < n) {
                p2++;
                sum = sum + p2;
            } else if(sum > n) {
                sum = sum - p1;
                p1++;
            } else if(sum == n) {
                answer++;
                sum = sum - p1;
                p1++;
                p2++;
                sum = sum + p2;
            } 
        }
        
        return answer;
    }
}