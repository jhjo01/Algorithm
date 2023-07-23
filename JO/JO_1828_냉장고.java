package day0816;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JO_1828_냉장고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] data = new int[N][2];
		List<int[]> chem = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				data[i][j] = sc.nextInt();
			}
		}
		
		
		
		for(int i = 0; i < N-1; i++)
		{
			for(int j = i+1; j < N; j++)
			{
				if(Math.abs(data[i][0] - data[i][1]) > Math.abs(data[j][0] - data[j][1]))
				{
					int[] temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
				
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			chem.add(data[i]);
		}
		
		List<int[]> ref = new ArrayList<>();
		ref.add(chem.get(0));
		chem.remove(0);
		
		outer : for(int i = 0; i < chem.size();)
		{
			for(int j = 0; j < ref.size(); j++)
			{
				if(chem.size() == 0) break;
				int c0 = chem.get(i)[0];
				int c1 = chem.get(i)[1];
				int r0 = ref.get(j)[0];
				int r1 = ref.get(j)[1];
				if((chem.get(i)[0] <= ref.get(j)[0] || chem.get(i)[0] <= ref.get(j)[1]) &&
						(chem.get(i)[1] >= ref.get(j)[0] || chem.get(i)[1] >= ref.get(j)[1]))
				{	
					chem.remove(i);
					continue outer;
				}
			}
			
			if(chem.size() == 0) break;
			ref.add(chem.get(i));
			chem.remove(i);
		}
		
		
		
		
		
		
//		for(int i = 0; i < N; i++)
//		{
//			for(int j = 0; j < 2; j++)
//			{
//				System.out.print(data[i][j] + " ");
//			}
//			System.out.println();
//		}
		
//		if(N==21)ref.add(ref.get(0));
		
		System.out.println(ref.size());
		
	}
}
