import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        Map<String, Integer> idx = new HashMap<>();
        idx.put(records[0].split(" ")[1], 0);
        
        for(int i = 1; i < records.length; i++) {
            if(idx.containsKey(records[i].split(" ")[1])) continue;
            idx.put(records[i].split(" ")[1], Collections.max(idx.values()) + 1);
        }
        
        int[][] acc = new int[idx.size()][2];
        
        for(int i = 0; i < records.length; i++) {
            int index = idx.get(records[i].split(" ")[1]);
            int time = Integer.parseInt(records[i].split(" ")[0].split(":")[0]) * 60;
            time = time + Integer.parseInt(records[i].split(" ")[0].split(":")[1]);
            
            if(records[i].split(" ")[2].equals("IN")) {
                acc[index][0] = time;
            } else {
                acc[index][1] = acc[index][1] + time - acc[index][0];
                acc[index][0] = -1;
            }
        }
        
        answer = new int[acc.length];
        
        List<String> keyList = new ArrayList<>(idx.keySet());
        Collections.sort(keyList);
        
        for(int i = 0; i < acc.length; i++) {
            int index = idx.get(keyList.get(i));
            if(acc[index][0] != -1) acc[index][1] = acc[index][1] + (1439 - acc[index][0]);
            if(acc[index][1] < fees[0]) answer[i] = fees[1];
            else {
                answer[i] = fees[1] + (((acc[index][1] - fees[0]) / fees[2]) * fees[3]);
                if((acc[index][1] - fees[0]) % fees[2] != 0) answer[i] = answer[i] + fees[3];
            }
        }
        
        return answer;
    }
}