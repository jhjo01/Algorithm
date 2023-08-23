import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        List<Integer> lostList = new ArrayList<>();
        for (int l : lost) {
            lostList.add(l);
        }
        List<Integer> reserveList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }
        for (int l : lost) {
            if (reserveList.contains(l)) {
                reserveList.remove(Integer.valueOf(l));
                lostList.remove(Integer.valueOf(l));
                answer++;
            }
        }

        Collections.sort(lostList);

        for (int i = 0; i < lostList.size(); i++) {
            int currentLost = lostList.get(i);
            if (reserveList.contains(currentLost - 1)) {
                reserveList.remove(Integer.valueOf(currentLost - 1));
                answer++;
            } else if (reserveList.contains(currentLost + 1)) {
                reserveList.remove(Integer.valueOf(currentLost + 1));
                answer++;
            }
        }

        return answer;
    }
}
