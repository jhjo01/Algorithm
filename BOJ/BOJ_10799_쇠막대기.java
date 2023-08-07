import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int answer = 0;
        int cnt = 0; // 자를 철근 갯수
        int cnt2 = 0; // 원래 철근 갯수
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                cnt++;
                continue;
            }
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    cnt--;
                    answer = answer + cnt;
                } else {
                    cnt--;
                    cnt2++;
                }
            }
        }
        answer = answer + cnt2;

        System.out.println(answer);
    }
}