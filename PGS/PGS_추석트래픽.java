package PGS;

import java.util.HashMap;

public class PGS_추석트래픽 {
    public static void main(String[] args) {
        String[] s = {"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        System.out.println(solution(s));
    }

    public static int solution(String[] lines) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap();

        for(int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            System.out.println(split[0]);
            System.out.println(split[1]);
            System.out.println(split[2]);
        }

        return answer;
    }
}
