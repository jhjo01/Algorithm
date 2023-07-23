import java.util.Scanner;

public class D2_2001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int numA = sc.nextInt();
			int numB = sc.nextInt();
			
			int[][] aryA = new int[numA][numA];
			
			for(int i = 0; i < numA; i++)
			{
				for(int j = 0; j < numA; j++)
				{
					aryA[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			
			for(int i = 0; i < numA; i++)
			{
				for(int j = 0; j < numA; j++)
				{
					int temp = 0;
					int icount = 0;
					int loopcount = 0;
					//System.out.println("LOOP");
					for(int k = i; k < numA; k++)
					{
						int kcount = 0;
						for(int l = j; l < numA; l++)
						{
							if(icount < numB && kcount < numB)
							{
								temp = temp + aryA[k][l];
								//System.out.println("tmep=" + temp +" aryA="+aryA[k][l]);
								//System.out.println("aryA["+i+"]["+j+"]" + "=" + aryA[i][j]);
								//System.out.println("aryB["+k+"]["+l+"]" + "=" + aryA[k][l] + "\n");
								if(l == numA-1)
								{
									break;
								}
								kcount++;
								loopcount++;
							}
						}
						if(k == numA-1)
						{
							break;
						}
						icount++;
					}
					//System.out.println("Loopcount="+loopcount);
					if(max < temp)
					{
						max = temp;
					}
					
				}
			}
			

			
			
			
			
			
			System.out.println("#" + test_case + ' ' + max);
			
		}
		

		
		sc.close();

	}

}
