package day0804;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> cardArr = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			cardArr.add(i);
		}
		
		for(int i = 0; i < N-1; i++) {
			cardArr.remove();
			cardArr.add(cardArr.poll());
		}
		int ans = cardArr.peek();
		
		System.out.println(ans);
	}
	
	
}
