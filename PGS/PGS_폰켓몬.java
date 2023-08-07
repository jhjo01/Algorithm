import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int n = set.size(); // 포켓몬 종류
        int k = nums.length / 2; // 뽑아야할 포켓몬 수

        // 뽑아야할 포켓몬 수가 포켓몬 종류보다 많으면 포켓몬 종류 return
        if(n <= k) answer = n;
        else {
            answer = k;
        }

        return answer;
    }
}