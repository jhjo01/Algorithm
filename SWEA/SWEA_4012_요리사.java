package day0812;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_4012_요리사 {
	static int N, R, ans = 9999999;
	static int[] numbers;
	static int[][] map;
	static List<int[]> list = new ArrayList<>();
	// nCr : n개의 입력받은 수 중 r개를 모두 뽑아 순서 없이 나열한 것
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		N = sc.nextInt();
		R = N/2;
		map = new int[N][N];
		numbers = new int[R]; // 뽑은 수 
		
		for (int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		
		comb(0, 0);
		
		int k = 0;
		while(k != list.size())
		{
			int sum = 0;
			int total = 0;
			boolean[] check = new boolean[N];
			for(int i = 0; i < list.size(); i++)
			{
				numbers = list.get(i);
				for(int j = 0; j < numbers.length-1; j++)
				{
//					if(i == j) continue;
					
					if(check[numbers[j]] || check[numbers[j+1]])
					{
//						System.out.println("total " + Arrays.toString(numbers));
//						total = total +  map[numbers[j]][numbers[j+1]];
						continue;
					}
					System.out.println(Arrays.toString(numbers));
					sum += map[numbers[j]][numbers[j+1]];
					sum += map[numbers[j+1]][numbers[j]];
					check[numbers[j]] = true;
					check[numbers[j+1]] = true;
				}
				
			}
			System.out.println();
			
			int[] temp = list.get(0);
			list.remove(0);
			list.add(temp);
			
			ans = Math.min(ans, Math.abs(total-sum));
			k++;
		}
		
		
		System.out.println(ans);
	}
	
	// cnt + 1 번째에 해당하는 조합에 포함될 수를 뽑기
	private static void comb(int cnt, int start) // cnt : 직전까지 뽑은 조합에 포함된 수의 개수, start : 시도할 수의 시작 위치
	{
		if(cnt == R)
		{ 	
			list.add(numbers.clone());
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수에 대해 시도(input 배열의 가능한 수 시도)
		// start 부터 처리시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		for (int i = start; i < N; i++)
		{
			// start 위치부터 처리했으므로 중복체크 필요없음!!
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = i;
			// 다음 수 뽑으러 가기
			comb(cnt + 1, i + 1); // start는 시작위치만 결정 i가 돌면서 조합 생성함
			// 사용했던 수에 대한 선택을 되돌리기
		}
	}
}