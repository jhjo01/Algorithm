import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zeroCnt = 0;
        int matchCnt = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < win_nums.length; i++) set.add(win_nums[i]);
        
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) zeroCnt++;
            else if(set.add(lottos[i])) continue;
            else matchCnt++;
        }
        
        answer[0] = zeroCnt + matchCnt == 0 ? 6 : 7 - (zeroCnt + matchCnt);
        answer[1] = matchCnt == 0 ? 6 : 7 - matchCnt;
        
        return answer;
    }
}