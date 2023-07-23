class Solution {
    public int solution(int[][] sizes) {
        int maxW = Integer.max(sizes[0][0], sizes[0][1]);
        int maxH = Integer.min(sizes[0][0], sizes[0][1]);
        
        for(int i = 1; i < sizes.length; i++) {
            int w = Integer.max(sizes[i][0], sizes[i][1]);
            int h = Integer.min(sizes[i][0], sizes[i][1]);
            
            maxW = Integer.max(maxW, w);
            maxH = Integer.max(maxH, h);

        }
        
        int answer = maxW * maxH;
        return answer;
    }
}