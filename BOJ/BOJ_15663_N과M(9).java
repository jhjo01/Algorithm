import java.util.*;

public class Main {
    static int N, R;
    static int[] numbers, selectedNumber;
    static boolean[] isSelected;
    static Set<String> set;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        numbers = new int[N];
        selectedNumber = new int[R];
        isSelected = new boolean[N];
        set = new HashSet<>();
        sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        perm(0);

        System.out.println(sb.toString());
    }

    public static void perm(int cnt) {
        if(cnt == R) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < R; i++) {
                temp.append(selectedNumber[i]);
                temp.append("/");
            }
            String s = temp.toString();
            if(set.add(s)) {
                for(int i = 0; i < R; i++) {
                    sb.append(selectedNumber[i]);
                    sb.append(" ");
                }
                sb.append("\n");
            }

        } else {
            for(int i = 0; i < N; i++) {
                if(isSelected[i]) continue;
                selectedNumber[cnt] = numbers[i];
                isSelected[i] = true;
                perm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }


}