package PGS;

import java.util.*;

public class PGS_단어변환 {
    public static void main(String[] args) {
        int res = solution("hit", "hot", new String[] {"hit", "hot", "lot"});

        System.out.println(res);

    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        // target이 words에 있는지 확인
        int targetIdx = -1;
        for(int i = 0; i < words.length; i++) if(target.equals(words[i])) {
            targetIdx = i;
            break;
        }
        if(targetIdx == -1) {
            return 0;
        }


        // 2차원 배열에 이동 가능한 곳을 미리 마킹
        int wordLen = words.length;
        int[][] array = new int[wordLen][wordLen];
        for(int i = 0; i < wordLen; i++) {
            for(int j = 0; j < wordLen; j++) {
                int cnt = 0;

                for(int k = 0; k < words[i].length(); k++) {
                    if(words[i].charAt(k) != words[j].charAt(k)) {
                        cnt++;
                    }
                    if(cnt > 1) {
                        array[i][j] = 0;
                        array[j][i] = 0;
                        break;
                    }
                }

                if(cnt == 1) {
                    array[i][j] = 1;
                    array[j][i] = 1;
                }
            }
        }

        // 방문여부 판단할 2차원 배열
        boolean[][] visited = new boolean[wordLen][wordLen];

        // BFS에 사용할 큐 선언
        Queue<int[]> queue = new ArrayDeque<>();

        // begin에서 갈수있는것도 필요함
        int orderCnt = 0;
        for(int i = 0; i < wordLen; i++) {
            int cnt = 0;
            for(int j = 0; j < begin.length(); j++)
                if(begin.charAt(j) != words[i].charAt(j)) {
                    cnt++;
                    if(cnt > 1) break;
                }
            if(cnt == 1) queue.offer(new int[] {orderCnt, i, 1});
        }

        // BFS 완탐
        // orderNo, now, cnt
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int orderNo = temp[0];
            int now = temp[1];
            int cnt = temp[2];
            if(now == targetIdx) return cnt;

            for(int i = 0; i < wordLen; i++) {
                if(array[now][i] > 0 && !visited[orderNo][i]) {
                    if(i == targetIdx) return cnt+1;
                    queue.offer(new int[] {orderNo, i, cnt+1});
                    visited[orderNo][i] = true;
                }
            }
        }
        return answer;

    }
}
