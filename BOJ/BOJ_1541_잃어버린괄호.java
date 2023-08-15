import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        // split string
        String[] ss = s.split("-");


        int sum;

        String[] sss = ss[0].split("\\+");
        sum = 0;
        for(int j = 0; j < sss.length; j++) {
            sum = sum + Integer.parseInt(sss[j]);
        }

        if(ss.length > 1) {
            for(int i = 1; i < ss.length; i++) {
                // split split string
                sss = ss[i].split("\\+");
                int sSum = 0;
                for(int j = 0; j < sss.length; j++) {
                    sSum = sSum + Integer.parseInt(sss[j]);
                }
                sum = sum - sSum;
            }

        }

        System.out.println(sum);



    }
}