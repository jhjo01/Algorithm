import java.util.*;

// 재귀 호출을 통한 조합 생성
class Solution {
    int[] input, selectedNumbers;
    int n, r;
    Set<Integer> set;
    
    public int[] solution(int[] numbers) {
        int[] answer;
        
        n = numbers.length;
        r = 2;
        set = new TreeSet<>();
        input = numbers;
        selectedNumbers = new int[r];
        
        comb(0, 0);
        
                
        answer = new int[set.size()];
        
        Iterator<Integer> iter = set.iterator();
        int i = 0;
        while(iter.hasNext()) {
            answer[i++] = iter.next();
        }
        
        return answer;
    }
    
    public void comb(int cnt, int start) {
        if(cnt == r) {
            int sum = 0;
            for(int i = 0; i < r; i++) {
                sum = sum + selectedNumbers[i];
            }
            set.add(sum);
        } else {
            for(int i = start; i < n; i++) {
                selectedNumbers[cnt] = input[i];
                comb(cnt + 1, i + 1);
            }
        }
        
    }
}