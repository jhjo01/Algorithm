import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();
        long Z = getWinRate(X, Y);
        if(X == Y || Z == 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = Long.MAX_VALUE;

        while(true) {
            long offset = (right + left) / 2;
            if(left == offset) break;
            if(offset == 0) break;
            if(getWinRate(X + offset, Y + offset) == Z) left = offset;
            else if(getWinRate(X + offset, Y + offset) > Z) right = offset;
        }

        System.out.println(right);

    }

    public static long getWinRate(long x, long y) {
        return (long)(y * 100.0 / x);
    }
}