import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		String[] arr = new String[test_case];
		sc.nextLine();
		
		for(int i = 0; i < test_case; i++)
		{
			arr[i] = sc.nextLine(); 
		}
		
		Arrays.sort(arr);
		
//		for(int i = 0; i < test_case; i++)
//		{
//			System.out.println(arr[i]);
//		}
		
		for(int i = 0; i < test_case; i++)
		{
			int min = arr[i].length();
			int index = i;
			for(int j = i; j < test_case; j++)
			{
				if(min > arr[j].length())
				{
					min = arr[j].length();
					index = j;
				}
			}
			
			String temp = arr[index];
			for(int j = index; j > i ; j--)
			{
				arr[j] = arr[j - 1];
			}
			
			arr[i] = temp;

		}
		
		for(int i = 0; i < test_case; i++)
		{	if(i != 0 && arr[i].equals( arr[i-1])) continue;
			System.out.println(arr[i]);
		}
		
	}
}
