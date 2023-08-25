class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number + 1];
        
        for(int i = 1; i <= number; i++) {
            int j = 1;
            while(i * j <= number) {
                arr[i * j]++;
                j++;
            }
        }
        
        for(int i = 1; i <= number; i++) {
            if(arr[i] > limit) answer += power; 
            else answer += arr[i];
        }
        
        return answer;
    }
}