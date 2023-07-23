import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // set[]에 저장
        // value[] : 신고한사람
        // length가 k개 이상인 set에 있는 사람들에게 결과 통보
        
        int n = id_list.length;
        int[] answer = new int[n];
        Set<String>[] set = new HashSet[n];
        List list = Arrays.asList(id_list);
        
        for(int i = 0; i < n; i++) {
            set[i] = new HashSet<String>();
        }
        
        for(int i = 0; i < report.length; i++) {
            String sender = report[i].split(" ")[0];
            String reciver =  report[i].split(" ")[1];
            
            set[list.indexOf(reciver)].add(sender);
        }
        
        for(int i = 0; i < n; i++) {
            if(set[i].size() >= k) {
                Iterator<String> it = set[i].iterator();
                while(it.hasNext()) {
                    answer[list.indexOf(it.next())]++;
                }
            }
        }
        
        
        
        return answer;
    }
}