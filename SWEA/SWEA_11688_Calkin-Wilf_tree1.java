import java.util.Scanner;

public class D3_11688 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = 1;
			int b = 1;
			
			String lr = sc.nextLine();
			String[] lrSplit = lr.split("");
			
			for(int i = 0; i < lrSplit.length; i++)
			{
				if(lrSplit[i].equals("R"))
				{
					a = a + b;
				}
				else
				{
					b = b + a;
				}
			}
			
			System.out.println("#" + test_case + " " + a + " " + b);
			
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}

	}

}
