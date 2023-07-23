import java.util.Scanner;

public class D2_1959 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		int numA, numB;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			numA = sc.nextInt();
			numB = sc.nextInt();
			
			int[] aryA = new int[numA];
			int[] aryB = new int[numB];
			
			int sum = 0;
			
			// input aryA
			for(int i = 0; i < numA; i++)
			{
				aryA[i] = sc.nextInt();
			}
			
			// input aryB
			for(int i = 0; i < numB; i++)
			{
				aryB[i] = sc.nextInt();
			}
			
			// calc
			if(numA > numB)
			{
				for(int i = 0; i < numA-numB+1; i++)
				{
					int temp = 0;
					
					for(int j = 0; j < numB; j++)
					{
						temp = temp + aryA[i+j] * aryB[j];
					}
					if(sum < temp)
					{
						sum = temp;
					}
				}
			}
			else
			{
				for(int i = 0; i < numB-numA+1; i++)
				{
					int temp = 0;
					
					for(int j = 0; j < numA; j++)
					{
						temp = temp + aryA[j] * aryB[i+j];
					}
					if(sum < temp)
					{
						sum = temp;
					}
				}
			}
			
			System.out.println("#"+test_case+' '+sum);
			
		}
		
		
		sc.close();


	}

}
