package day1011;

import java.util.Scanner;

public class SWEA_활주로 {
	static int N, X, map[][], map2[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = sc.nextInt();
			X = sc.nextInt();
			
			map = new int[N][N]; // 수평 활주로 체크용
			map2 = new int[N][N]; // 수직 활주로 체크용
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map2[j][i] = map[i][j] = sc.nextInt();
				}
			}
			
			
			System.out.println("#" + test_case + " " + process());
		}
	}
	
	private static int process() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(makeRoad(map[i])) count++;
			if(makeRoad(map2[i])) count++;
		}
		
		return count;
	}
	
	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], size = 0;
		int j = 0;
		
		while(j < N) {
			if(beforeHeight == road[j]) { // 동일 높이 
				size++;
				j++;
			} else if(beforeHeight + 1 == road[j]) { // 이전보다 1 높음 : 오르막 경사로 설치 체크
				if(size < X) return false; // X 길이 미만이면 활주로 건설 불가
				
				beforeHeight++;
				size = 1;
				j++;
			} else if(beforeHeight - 1 == road[j]) { // 이전 높이보다 1 작음
				int count = 0;
				for(int k = j; k < N; k++) {
					if(road[k] != beforeHeight - 1) return false; 
					
					if(++count == X) break;
				}
				
				if(count < X) return false;
				
				beforeHeight--;
				j += X;
				size = 0;
				
			} else { // 높이가 2이상 차이
				return false;
			}
		}
		return true;
	}
}
