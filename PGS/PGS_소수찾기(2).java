import java.util.*;

class Solution {
    int len, answer;
    boolean[] prime, isSelected;
    int[] selectedIndex;
    Set<Integer> set;
    String str;
    public int solution(String numbers) {
        answer = 0;
        len = numbers.length();
        isSelected = new boolean[len];
        selectedIndex = new int[len];
        set = new HashSet<>();
        str = numbers;
        
        prime = new boolean[(int)Math.pow(10, numbers.length())];
        Arrays.fill(prime, true);
        
        for(int i = 2; i < prime.length; i++) {
            for(int j = 2; j * i < prime.length; j++) {
                prime[i*j] = false;
            }
        }
        
        dfs(0);
        
        
        return answer;
    }
    
    public void dfs(int cnt) {
        String s = "";
        for(int i = 0; i < cnt; i++) {
            s =  s + String.valueOf(str.charAt(selectedIndex[i]));
        }
        if(cnt > 0 && set.add(Integer.parseInt(s))) {
            int num = Integer.parseInt(s);
            if(num > 1 && prime[num]) {
                answer++;
            }
        }
        
        if(cnt == len) return;
        
        for(int i = 0; i < len; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            selectedIndex[cnt] = i;
            dfs(cnt + 1);
            isSelected[i] = false;
        }
    }
}