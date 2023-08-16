import java.util.*;

class Solution {
    class Fr implements Comparable<Fr> {
        int idx;
        double fr;
        
        public Fr(int idx, double fr) {
            this.idx = idx;
            this.fr = fr;
        }

        
        @Override
        public int compareTo(Fr o) {
            if(fr == o.fr) {
                return idx - o.idx;                
            }
            
            if(o.fr > fr) {
                return 1;
            } 
            return -1;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int cnt = stages.length;
        int[] roundUserCnt = new int[N];
        List<Fr> list = new ArrayList<>();
        
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] > N) continue;
            roundUserCnt[stages[i] - 1]++;
        }
        
        for(int i = 0; i < roundUserCnt.length; i++) {
            double fr = roundUserCnt[i] / (double)cnt;
            if(cnt == 0) fr = 0;
            list.add(new Fr(i, fr));
            cnt = cnt - roundUserCnt[i];
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).idx + 1;
        }
        
        return answer;
    }
}