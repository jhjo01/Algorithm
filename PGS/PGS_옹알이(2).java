class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] oay = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++) {
            for(int j = 0; j < oay.length; j++) {
                if(babbling[i].contains(oay[j] + oay[j])) break;
                babbling[i] = babbling[i].replace(oay[j], " ");
            }
            babbling[i] = babbling[i].replace(" ", "");
            if(babbling[i].length() == 0) answer++;
        }
        
        return answer;
    }
}