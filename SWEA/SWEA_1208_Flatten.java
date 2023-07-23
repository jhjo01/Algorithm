package com.ssafy.recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		

//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			int N = sc.nextInt();
//			int[] data = new int[100];
//			
//			for(int i = 0; i < 100; i++)
//			{
//				data[i] = sc.nextInt();
//			}
//			
//			for(int i = 0; i < N; i++)
//			{
//				int max = 0;
//				int maxIdx = i;
//				int min = 101;
//				int minIdx = i;
//				for(int j = 0; j < 100; j++)
//				{
//					if(data[j] > max)
//					{
//						max = data[j];
//						maxIdx = j;
//					}
//					if(data[j] < min)
//					{
//						min = data[j];
//						minIdx = j;
//					}
//				}
//				
//				data[maxIdx]--;
//				data[minIdx]++;
//			}
//			
//			int max = 0;
//			int min = 101;
//			for(int j = 0; j < 100; j++)
//			{
//				if(data[j] > max)
//				{
//					max = data[j];
//				}
//				if(data[j] < min)
//				{
//					min = data[j];
//				}
//			}
//			
//			System.out.println("#" + test_case + " " + (max-min));
//		}

		/////////////////////////////////////////////////////////////////////////
		// 정렬 후 min++ max--
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(bf.readLine());
			int[] data = new int[100];
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int idx = 0;
			while(st.hasMoreTokens())
			{
				data[idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
			
			Arrays.sort(data);
			
			for(int i = 0; i < N; i++)
			{
				int maxIdx = 0;
				int minIdx = 0;
				int comMax = 0;
				int comMin = 0;
				for(int j = 0; j < 50; j++)
				{
					if(data[j] < data[j+1] && comMin == 0)
					{
						minIdx = j;
						comMin = 1;
					}
					if(data[99-j] > data[99-j-1] && comMax == 0)
					{
						maxIdx = 99-j;
						comMax = 1;
					}
					if(comMin + comMax == 2) break;
				}
				
				data[maxIdx]--;
				data[minIdx]++;
			}
			
			int max = 0;
			int min = 101;
			for(int j = 0; j < 100; j++)
			{
				if(data[j] > max)
				{
					max = data[j];
				}
				if(data[j] < min)
				{
					min = data[j];
				}
			}
			
			System.out.println("#" + test_case + " " + (max-min));
		}
		

	}
}
