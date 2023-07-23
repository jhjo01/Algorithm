import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] nums = new int[num];
		
		for(int i = 0; i < num; i++)
		{
			nums[i] = sc.nextInt();
		}
		
		for(int i = 0; i < num; i++)
		{
			for(int j = 0; j < num-1;	j++)
			{
				if(nums[j] > nums[j+1])
				{
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		for(int i = 0; i < num; i++)
		{
			System.out.println(nums[i]);
		}
	}
}
