package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	static int[] data;
	static int[] target;
	
	public static void main(String[] args) throws Exception  {
		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//int N = sc.nextInt();
		int N = Integer.parseInt(bf.readLine());
		
		data = new int[N];
		target = new int[N];
		int maxIdx = 0;
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++)
		{
			//data[i] = sc.nextInt();
			data[i] = Integer.parseInt(st.nextToken());
			
			if(max < data[i])
			{
				max = Math.max(max, data[i]);
				maxIdx = i;
				target[i] = -1;
				continue;
			}
			
			
			
			if(data[i] < max)
			{
				target[i] = maxIdx; 
			}
			
			if(data[i] > data[i-1])
			{
				target[i] = getprev(i, i-1);
			}
			
			if(data[i] < data[i-1]) target[i] = i-1;
			
			
						
		}
		
		for(int i = 0; i < N; i++)
		{
			System.out.print((target[i] + 1) + " ");
		}
		
	}
	
	
	private static int getprev(int dataIdx, int prevIdx)
	{
		if(data[dataIdx] <= data[target[prevIdx]]) return target[prevIdx];
		
		return getprev(dataIdx, target[prevIdx]);
	}
}
