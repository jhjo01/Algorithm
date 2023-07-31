import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Arrays.fill(answer, -1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        
        for(int i = 0; i < numbers.length; i++) {
            pq.offer(new int[] {numbers[i], i});
            
            while(pq.peek()[0] < numbers[i]) {
                int[] temp = pq.poll();
                answer[temp[1]] = numbers[i];
            }
        }
        
        return answer;
    }
}