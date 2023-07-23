import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(i + 3 > list.size()) break;
            if( list.get(i) == 1) // 1
                if( list.get(i + 1) == 2) // 2 
                    if( list.get(i + 2) == 3) // 3
                        if( list.get(i + 3) == 1) { // 1
                            list.remove(i);
                            list.remove(i);
                            list.remove(i);
                            list.remove(i);
                            answer++;
                            if(i <  4) {
                                i = -1;
                                continue;
                            }
                            i = i - 4;
                        }
        }
        
        return answer;
    }
}