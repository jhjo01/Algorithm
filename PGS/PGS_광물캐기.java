import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int n = 0;
        for(int pick : picks) n = n + pick * 5;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
            if(o1[0] > o2[0]) return -1;
            else if(o1[0] == o2[0]) 
                if(o1[1] > o2[1]) return -1;
                else if(o1[1] == o2[1])
                    if(o1[2] > o2[2]) return -1;
            return 1;
        });
        
        outer : for(int i = 0; i < minerals.length && i < n; i += 5) {
            int[] pick = new int[3];
            for(int j = 0; j < 5; j++) {
                if(i + j >= minerals.length || i + j >= n) {
                    pq.offer(pick);
                    break outer;
                } else {
                    switch(minerals[i+j]) {
                        case "diamond": {
                            pick[0]++;
                            break;
                        }
                        case "iron": {
                            pick[1]++;
                            break;
                        }
                        case "stone": {
                            pick[2]++;
                            break;
                        }
                    }
                }
            }
            pq.offer(pick);
        }
        
        while(!pq.isEmpty()) {
            int[] pick = pq.poll();
            
            if(picks[0] != 0) {
                answer += pick[0] + pick[1] + pick[2];
                picks[0]--;
            } else if(picks[1] != 0) {
                answer += (pick[0] * 5) + pick[1] + pick[2];
                picks[1]--;
            } else {
                answer += (pick[0] * 25) + (pick[1] * 5) + pick[2];
            }
        }
        
        return answer;
    }
}
