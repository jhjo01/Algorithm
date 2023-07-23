package day0811;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_3040_백설공주와일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> data = new ArrayList<>();
		int sum = 0;
		for(int i = 0; i < 9; i++)
		{
			data.add(sc.nextInt());
			sum += data.get(i);
		}
		
		boolean find = false;
		for(int i = 0; i < data.size()-1; i++)
		{
			for(int j = i+1; j < data.size(); j++)
			{
				int temp = sum - (data.get(i) + data.get(j));
				if(sum - (data.get(i) + data.get(j)) == 100)
				{
					data.remove(i);
					data.remove(j-1);
					find = true;
					break;
				}
			}
			if(find) break;
		}
		
		for(int i = 0; i < 7; i++)
		{
			System.out.println(data.get(i));
		}
	}
}
