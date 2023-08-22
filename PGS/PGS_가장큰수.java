import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        // Comparator를 사용하여 두 숫자를 비교
        Arrays.sort(nums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        // 만약 가장 큰 수가 0으로 시작한다면 0
        if (nums[0].equals("0")) {
            return "0";
        }
        
        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }
        
        return answer.toString();
    }
}
