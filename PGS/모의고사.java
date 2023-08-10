import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(first[i % first.length] == answers[i]) cnt1++;
            if(second[i % second.length] == answers[i]) cnt2++;
            if(third[i % third.length] == answers[i]) cnt3++;
        }
        
        // max 값 찾기
        int max = Math.max(Math.max(cnt1, cnt2), cnt3);
        // max값인거 카운트
        List<Integer> list = new ArrayList<>();
        if(cnt1 == max) list.add(1);
        if(cnt2 == max) list.add(2);
        if(cnt3 == max) list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}