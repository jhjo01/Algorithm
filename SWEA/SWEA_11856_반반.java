import java.util.Scanner;

public class D3_11856 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		sc.nextLine();
		
		outer : for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String s = sc.nextLine();
			
			int cnt[] = new int[4];
			
			for(int i = 0; i < 4; i++)
			{
				for(int j = 0; j < 4; j++)
				if(s.charAt(i) == s.charAt(j)) cnt[i]++;
			}
			
			for(int i = 0; i < 4; i++)
			{
				if(cnt[i] != 2)
				{
					System.out.println("#" + test_case + " No");
					continue outer;
				}
				
			}
			
			
			 System.out.println("#" + test_case + " Yes");
		}

	}

}
