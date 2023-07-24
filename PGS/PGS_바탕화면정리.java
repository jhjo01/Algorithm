class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        answer[0] = 51; // minX
        answer[1] = 51; // minY
        answer[2] = -1; // maxX
        answer[3] = -1; // maxY
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[0].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    answer[0] = Math.min(answer[0], i);
                    answer[2] = Math.max(answer[2], i + 1);
                    answer[1] = Math.min(answer[1], j);
                    answer[3] = Math.max(answer[3], j + 1);
                }
            }
        }

        return answer;
    }
}