import java.util.Scanner;

public class D2_1974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int sudoku = 9;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[][] aryA = new int[sudoku][sudoku];
			int check_sudoku = 1;
			
			// input
			for(int i = 0; i < sudoku; i++)
			{
				for(int j = 0; j < sudoku; j++)
				{
					aryA[i][j] = sc.nextInt();
				}
			}
			
			int[] check33_1 = new int[sudoku+1];
			int[] check33_2 = new int[sudoku+1];
			int[] check33_3 = new int[sudoku+1];
			int count33 = 0;
			int tempcount = 0;
			
			// horizon, vertical check
			for(int i = 0; i < sudoku; i++)
			{
				int[] hcheck = new int[sudoku+1];
				int[] vcheck = new int[sudoku+1];
				
				for(int j = 1; j < sudoku+1; j++)
				{
					// horizon check
					if(hcheck[aryA[i][j-1]] == 0)
					{
						hcheck[aryA[i][j-1]] = aryA[i][j-1];
					}
					else
					{
						check_sudoku = 0;
						break;
					}
					
					// vertical check
					if(vcheck[aryA[j-1][i]] == 0)
					{
						vcheck[aryA[j-1][i]] = aryA[j-1][i];
					}
					else
					{
						check_sudoku = 0;
						break;
					}
					
					
					// 3x3 check
					count33++;
					if(j > 0 && j < 4)  // j 1~3
					{
						if(check33_1[aryA[i][j-1]] == 0)
						{
							check33_1[aryA[i][j-1]] = aryA[i][j-1];
						}
						else
						{
							check_sudoku = 0;
							break;
						}
					}
					
					
					if(j > 3 && j < 7) // j 4~6
					{
						if(check33_2[aryA[i][j-1]] == 0)
						{
							check33_2[aryA[i][j-1]] = aryA[i][j-1];
						}
						else
						{
							check_sudoku = 0;
							break;
						}
					}
					
					
					if(j > 6 && j < 10) // 7~9
					{
						if(check33_3[aryA[i][j-1]] == 0)
						{
							check33_3[aryA[i][j-1]] = aryA[i][j-1];
						}
						else
						{
							check_sudoku = 0;
							break;
						}
					}
					
					
					
					if((count33)  % 3 == 0)
					{
						count33 = tempcount;
					}
				}
				tempcount = tempcount + 3;
				count33 = tempcount;
				
				if((i+1) % 3 == 0)
				{
					for(int k = 1; k < sudoku+1; k++)
					{
						check33_1[k] = 0;
						check33_2[k] = 0;
						check33_3[k] = 0;
						count33 = 0;
						tempcount = 0;
					}
				}
				
				
				if(check_sudoku == 0)
				{
					break;
				}
				
				
			}
			
			System.out.println("#"+ test_case + " " + check_sudoku);
		

		}
		
		sc.close();

	}
}
