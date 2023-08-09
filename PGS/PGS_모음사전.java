class Solution {
    public int solution(String word) {
        int answer = 0;
        
        // 반복문이나 dfs로 구현 가능
        // 작은 문제들을 반복하니까 dp나 수학적으로도 될거 같은데 모르겠음
        
        String[] ss = {"A", "E", "I", "O", "U"};
        
        // 5 * 5 * 5 * 5 * 5
        int cnt = 0;
        outer : for(int i = 0; i < 5; i++) {
            cnt++;
            if(ss[i].equals(word)) break;
            for(int j = 0; j < 5; j++) {
                cnt++;
                String js = ss[i] + ss[j];
                if(js.equals(word)) break outer;
                for(int k = 0; k < 5; k++) {
                    cnt++;
                    String ks = ss[i] + ss[j] + ss[k];
                    if(ks.equals(word)) break outer;
                    for(int l = 0; l < 5; l++) {
                        cnt++;
                        String ls = ss[i] + ss[j] + ss[k] + ss[l];
                        if(ls.equals(word)) break outer;
                        for(int m = 0; m < 5; m++) {
                            cnt++;
                            String ms = ss[i] + ss[j] + ss[k] + ss[l] + ss[m];
                            if(ms.equals(word)) break outer;
                        }
                    }
                }
            }
        }
        
        return cnt;
    }
    
    
}