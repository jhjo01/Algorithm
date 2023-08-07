import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        
        outer : for(int i = 0; i < skill_trees.length; i++) {
            int[] arr = new int[skill.length()];
            Arrays.fill(arr, -1);
            boolean isPossible = true;
            
            for(int j = 0; j < skill.length(); j++) {
                arr[j] = skill_trees[i].indexOf(skill.charAt(j));
            }
            
            // 오름차순으로 정렬되는지 확인
            // -1이 나오면 뒤에 있는것도 -1이 아니면 false
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] == -1 && arr[j + 1] == -1) {
                    continue;
                } else if(arr[j] == -1 && arr[j + 1] != -1) {
                    isPossible = false;
                    break;
                }
                if(arr[j] < arr[j + 1]) continue;
                else {
                    if(arr[j + 1] == -1) continue;
                    isPossible = false;
                    break;
                }
            }
            answer = isPossible ? ++answer : answer;
        }
        
        
        return answer;
    }
}