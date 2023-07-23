package day0816;

import java.util.Scanner;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int thr, fiv, fivMod;
		
		fiv = N / 5;
		fivMod = N % 5;
		
		if(N / 5 == 0)
		{
			if(fivMod % 3 != 0)
			{
				System.out.println("-1");
				return;
			}
		}
		
		while(true)
		{
			if(fivMod % 3 != 0)
			{
				fiv = fiv - 1;
				fivMod += 5;
			}
			else
			{
				thr = fivMod / 3;
				break;
			}
			
			if(fiv < 0)
			{
				System.out.println("-1");
				return;
			}
		}
		
		System.out.println(fiv+thr);
		
	}
}
