package day1011;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_15961_회전초밥 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 접시의 수
		int d = sc.nextInt(); // 초밥의 가짓구
		int k = sc.nextInt(); // 연속해서 먹는 접시의 수
		int c = sc.nextInt(); // 쿠폰 번호
		
		int[] data = new int[N];
		
		for(int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		
		int[] data2 = new int[d+1];
		
		int max = 0;
		int cur = 0;
		
		// init
		for(int i = 0; i < k; i++) {
			if(data2[data[i]] == 0) cur++;
			data2[data[i]]++;
		}
		
		max = cur;
		
		for(int i = 1; i< N; i++) {
			int start = data[i-1];
			data2[start]--;
			
			if(data2[start] == 0) cur--;
			
			
			int end = (i + k -1) % N;
			if(data2[data[end]] == 0) cur++;
			data2[data[end]]++;
			
			if(max <= cur) {
				if(data2[c] == 0) max = cur + 1;
				else max = cur;
			}
		}
		
		System.out.println(max);
		
		
	}
}	
