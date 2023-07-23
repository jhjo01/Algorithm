import java.util.Scanner;

public class D2_1979 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int numA = sc.nextInt();
			int numB = sc.nextInt();
			
			int[][] aryA = new int[numA+2][numA+2];
			
			int count = 0;
			
			//input
			for(int i = 1; i < numA+1; i++)
			{
				for(int j = 1; j < numA+1; j++)
				{
					aryA[i][j] = sc.nextInt();
				}
			}
			
			//calc
			for(int i = 1; i < numA+1; i++)
			{
				for(int j = 1; j < numA+1; j++)
				{
					//horizontal
					if(aryA[i][j-1] == 0 && aryA[i][j] == 1)
					{
						int temp = 0;
						for(int k = j; k < numA+1; k++)
						{
							if(aryA[i][k] == 1)
							{
								temp = temp + 1;
							}
							
							if(temp > numB || aryA[i][k] == 0)
							{
								break;
							}
						}
						
						if(temp == numB)
						{
							count = count + 1;
						}
					}
					
					
					//vertical
					if(aryA[j-1][i] == 0 && aryA[j][i] == 1)
					{
						int temp = 0;
						for(int k = j; k < numA+1; k++)
						{
							if(aryA[k][i] == 1)
							{
								temp = temp + 1;
							}
							
							if(temp > numB || aryA[k][i] == 0)
							{
								break;
							}
						}
						
						if(temp == numB)
						{
							count = count + 1;
						}
					}
				}
			}
			
			
			System.out.println("#" + test_case + ' ' + count);
			
		}
		
		
		sc.close();


	}

}
