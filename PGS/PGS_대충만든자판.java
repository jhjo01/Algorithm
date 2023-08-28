import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int[] arr = new int[26];
        Arrays.fill(arr, 101);
        
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                if(arr[keymap[i].charAt(j) - 65] > j + 1) {
                    arr[keymap[i].charAt(j) - 65] = j + 1;
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                cnt = arr[targets[i].charAt(j) - 65] == 101 ? -999999 :  cnt + arr[targets[i].charAt(j) - 65];
            }
            answer[i] = cnt < 0 ? -1 : cnt;
        }
        
        return answer;
    }
}