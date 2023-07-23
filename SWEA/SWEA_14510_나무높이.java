package SWEA;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_14510_나무높이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] data = new int[N+1];

            Queue<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                data[i+1] = sc.nextInt();
            }

            queue.offer(data);

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int day = temp[0];

                System.out.println(Arrays.toString(temp));

                boolean end = true;
                for (int i = 0; i < temp.length-2; i++) {
                    if(temp[i+1] != temp[i+2]) {
                        end = false;
                        break;
                    }
                }

                if(end) {
                    System.out.println("#" + test_case + " " + day);
                    break;
                }

                temp[0]++;

                queue.offer(temp);

                for (int i = 0; i < temp.length-1; i++) {
                    int[] copy = temp.clone();

                    if(day % 2 == 1) {
                        copy[i+1] = copy[i+1] + 2;
                    } else {
                        copy[i+1] = copy[i+1] + 1;
                    }
                        if(copy[i+1] >= 120) continue;
                        queue.offer(copy);

                }




            }



            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
