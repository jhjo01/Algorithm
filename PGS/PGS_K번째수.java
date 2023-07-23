import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            Queue<Integer> queue = new PriorityQueue<>();

            for(int j = commands[i][0]; j < commands[i][1]+1; j++) {
                queue.offer(array[j-1]);
            }

            List<Integer> list = new ArrayList<>();

            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }

            answer[i] = list.get(commands[i][2]-1);
        }
        
        return answer;
    }
}