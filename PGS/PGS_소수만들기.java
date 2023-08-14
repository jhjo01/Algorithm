class Solution {
    int[] numbers;
    boolean[] isSelected;
    int answer;
    public int solution(int[] nums) {
        answer = 0;
        numbers = nums;
        isSelected = new boolean[nums.length];
        comb(0, 0);

        return answer;
    }
    
    public void comb(int cnt, int start) {
        if(cnt == 3) {
            int sum = 0;
            for(int i = 0; i < numbers.length; i++) {
                if(isSelected[i]) sum = sum + numbers[i];
            }
            for(int i = 2; i < sum; i++) {
                if(sum % i == 0) return; 
            }
            answer++;
            return;
        }
        for(int i = start; i < numbers.length; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            comb(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }
}