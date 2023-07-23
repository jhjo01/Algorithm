package day1013;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407_조합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		BigInteger bN = BigInteger.ONE;
		BigInteger bM = BigInteger.ONE;
		
		for(int i = 0; i < M; i++) {
			bN = bN.multiply(new BigInteger(String.valueOf(N-i)));
			bM = bM.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(bN.divide(bM));
	}
}
