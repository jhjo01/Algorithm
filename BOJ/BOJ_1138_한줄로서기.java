import java.util.*;

public class Main {
	static int N;
	static int[] array;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 입력
		init(sc);
		
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			int cnt = 0;
			
			for(int j = 0; j < N; j++) {
				// 이미 누군가 있으면 자기보다 작은 사람
				if(array[j] == 0) {
					if(cnt == n) {
						array[j] = i + 1;
						break;
					}
					cnt++;
				}
			}
		}

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
		
		
		sc.close();
	}



	static void init(Scanner sc) {
		N = sc.nextInt();
		array = new int[N];
	}


}



