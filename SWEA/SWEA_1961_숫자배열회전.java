import java.util.Scanner;

public class D2_1961 {
	
	public static int[][] transpose90(int[][] aryA, int numA)
	{

		int[][] ary90 = new int[numA][numA];
		
		for(int i = 0; i < numA; i++)
		{
			for(int j = 0; j < numA; j++)
			{
				ary90[j][numA-i-1] = aryA[i][j];
			}
		}
		
		return ary90;
	}
	
	public static void printary(int[][] ary, int numA, int i)
	{
		for(int j = 0; j < numA; j++)
		{
			System.out.print(ary[i][j]);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int numA = sc.nextInt();
			
			int[][] aryA = new int[numA][numA];
			int[][] ary90 = new int[numA][numA];
			int[][] ary180 = new int[numA][numA];
			int[][] ary270 = new int[numA][numA];
			
			for(int i = 0; i < numA; i++)
			{
				for(int j = 0; j < numA; j++)
				{
					aryA[i][j] = sc.nextInt();
				}
			}
			
			ary90 = transpose90(aryA, numA);
			ary180 = transpose90(ary90, numA);
			ary270 = transpose90(ary180, numA);

				
			
			System.out.println("#" + test_case);
			
			for(int i = 0; i < numA; i++)
			{
				printary(ary90, numA, i);
				System.out.print(" ");
				printary(ary180, numA, i);
				System.out.print(" ");
				printary(ary270, numA, i);
				System.out.println();
			}
			
			
			
			
			
			
		}
		

		
		sc.close();

	}

}
