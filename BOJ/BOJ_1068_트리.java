import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[sc.nextInt()];
        int rootIdx = 0;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] == -1) rootIdx = i;
        }

        int removeIdx = sc.nextInt();
        if(arr[removeIdx] == -1) {
            System.out.println(0);
            return;
        }
        remove(removeIdx);
        
        int[] arr2 = new int[arr.length];
        int answer = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == -1){
                arr2[i] = -1;
                continue;
            }
            arr2[arr[i]]++;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(i == rootIdx) continue;
            if(arr2[i] == 0) answer++;
        }

        System.out.println(answer == 0 ? 1 : answer);

    }

    public static void remove(int index) {
        arr[index] = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == index) {
                remove(i);
                arr[i] = -1;
            }
        }
    }
}