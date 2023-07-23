import java.util.Scanner;


public class BOJ_1244 {
	public static int toggle(int sw)
	{
		if(sw == 1) return 0;
		else return 1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int switchNum = sc.nextInt();
		int[] switchState = new int[switchNum];
		for(int i = 0; i < switchNum; i++)
		{
			switchState[i] = sc.nextInt();
		}
		
		int stuNum = sc.nextInt();
		
		for(int i = 0; i < stuNum; i++)
		{
			// 1이면 남자 2면 여자
			int gender = sc.nextInt();
			int num = sc.nextInt();
			
			if(gender == 1) // 남자
			{
				for(int j = 1; j < switchNum+1; j++)
				{
					if(j % num == 0)
					{
						switchState[j-1] = toggle(switchState[j-1]);
					}
				}
			}
			else // 여자
			{
				int j = 1;
				while(true)
				{
					if(((num-1) + j < switchNum && (num-1) - j >= 0 && switchState[(num-1) + j] == switchState[(num-1) - j])  )
					{
						if(j == 1) switchState[num-1] = toggle(switchState[num-1]);
						
						switchState[num-1 + j] = toggle(switchState[num-1 + j]);
						switchState[num-1 - j] = toggle(switchState[num-1 - j]);
						
						j++;
						continue;
					}
					else if(j == 1)
					{
						switchState[num-1] = toggle(switchState[num-1]);
						break;
					}
					else break;
				}	
			}
			
		}
		
		for(int i = 1; i <= switchNum; i++)
		{
			System.out.print(switchState[i-1] + " ");
			if(i % 20 == 0) System.out.println();
		}
		
		
		
	}
}
