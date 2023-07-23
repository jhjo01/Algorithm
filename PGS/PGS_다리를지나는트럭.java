package PGS;

import java.util.*;

public class PGS_다리를지나는트럭 {
    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        int res = solution(bridge_length, weight, truck_weights);

        System.out.println(res);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int totalWeight = 0;
        int idx = 0;

        List<int[]> list = new ArrayList<>();
        list.add(new int[] {bridge_length, truck_weights[idx]});
        totalWeight += truck_weights[idx];
        idx++;


        while(idx < truck_weights.length || !list.isEmpty()) {
            List<int[]> temp = new ArrayList<>();

            for(int i = 0, size = list.size(); i < size; i++) {

                int[] temp2 = list.get(0);
                list.remove(0);
                temp2[0]--;

                if(temp2[0] > 0 ) {
                    temp.add(temp2);
                } else {
                    totalWeight -= temp2[1];
                }
            }

            if(idx < truck_weights.length && totalWeight+truck_weights[idx] <= weight) {
                temp.add(new int[] {bridge_length, truck_weights[idx]});
                totalWeight += truck_weights[idx];
                idx++;
            }

            list = temp;
            answer++;
        }



        return answer+1;
    }


}
