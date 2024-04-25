import java.util.*;

class Solution {
    int maxCnt, answer;
    boolean[] isSelected;
    List<String> list;
    
    public int solution(String[][] relation) {
        answer = 0;
        maxCnt = relation[0].length;
        list = new ArrayList<>();
        isSelected = new boolean[relation[0].length];
        
        // 부분조합을 이용
        powerSet(0, relation);  
        
        return answer;
    }
    
    public void powerSet(int cnt, String[][] relation) {
        if(cnt == maxCnt) {
            
            // 유일성 검사
            Set<String> set = new HashSet<>();
            for(int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < relation[i].length; j++) {
                    if(isSelected[j]) sb.append(relation[i][j]);
                }
                if(!set.add(sb.toString())) return;
            }
            
            // 최소성 검사
            String s = "";
            boolean flag = false;
            for(int i = 0; i < relation[0].length; i++) {
                if(isSelected[i]) s = s + i;
            }
            
            for(int i = 0; i < list.size(); i++){
                int c = 0;
                String tmp = list.get(i);
                for(int j = 0; j < relation[0].length; j++) {
                    if(isSelected[j])
                        for(int k = 0; k < list.get(i).length(); k++) {
                            if((char)(j + 48) == tmp.charAt(k)) c++;
                        }
                }
                if(c == tmp.length()) return;
            }
            
            list.add(s);
            answer++;
            
            return;
        }

        isSelected[cnt] = false;
        powerSet(cnt + 1, relation);
        
        isSelected[cnt] = true;
        powerSet(cnt + 1, relation);
    }
}
