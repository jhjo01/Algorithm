class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] map = new int[n][n];
        
        int row = 0;
        int col = 0;
        int num = 1;

        while (num <= answer.length) {
            // 하
            while (row < n && map[row][col] == 0) {
                map[row][col] = num;
                num++;
                row++;
            }
            row--;
            col++;

            // 우
            while (col < n && map[row][col] == 0) {
                map[row][col] = num;
                num++;
                col++;
            }
            col = col - 2;
            row--;

            // 상
            while (row >= 0 && col >= 0 && map[row][col] == 0) {
                map[row][col] = num;
                num++;
                row--;
                col--;
            }
            row = row + 2;
            col++;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index] = map[i][j];
                index++;
            }
        }

        return answer;
    }
}
