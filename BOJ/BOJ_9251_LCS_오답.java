package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9251_LCS_오답 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        int lenA = a.length();
        int lenB = b.length();

        char[] strA = new char[lenA];
        char[] strB = new char[lenB];

        for (int i = 0; i < lenA; i++) {
            strA[i] = a.charAt(i);
        }

        for (int i = 0; i < lenB; i++) {
            strB[i] = b.charAt(i);
        }

        int[] dpA = new int[lenA];
        int[] dpB = new int[lenB];

        dpA[lenA-1] = 1;
        dpB[lenB-1] = 1;
        int max = 1;

        /*
            1. 현재 문자열을 다른 문자열에서 탐색
            2. 다른 문자열에 현재 문자열이 있으면 +1
            3. 현재 문자열 이전의 문자열을 다른 문자열에 마지막으로 탐색한 부분부터 다시 탐색
            4. 다른 문자열에 현재 문자열이 있으면 +1


         */
//        if( lenA == lenB) {
        if(true) {
            int idx = lenB-1;
            for (int i = lenA - 2; i >= 0; i--) {
                int cnt = 0;
                int next = idx;
                boolean find = false;

                for (int j = i; j < lenA; j++) {
                    if (dpA[j] >= cnt && strA[i] < strA[j]) {
                        for (int k = idx; k >= 0; k--) {
                            if(strB[k] == strA[i]) {
                                cnt = dpA[j] + 1;
                                if(!find) {
                                    next = k == 0 ? 0 : k-1;
                                    find = true;
                                }
                                break;
                            }
                        }
                    }
                }
                if(find) idx = next;

                dpA[i] = cnt == 0 ? 1 : cnt;
                max = Math.max(max, dpA[i]);

                System.out.println(Arrays.toString(strA));
                System.out.println(Arrays.toString(strB));
                System.out.println(Arrays.toString(dpA));
                System.out.println(idx);
                System.out.println();
            }
        }
//         else {
//            System.out.println();
//        }

        System.out.println(max);


    }
}