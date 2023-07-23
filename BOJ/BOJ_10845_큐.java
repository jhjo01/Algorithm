package BOJ;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10845_큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();

            switch (s) {
                case "push":
                    queue.offer(sc.nextInt());
                    break;
                case "pop":
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
