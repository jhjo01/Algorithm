import java.util.*;

public class Main {
	static int N, res;
	static String[] array;
	
	public static void main(String[] args) {
		// 1. 입력
		init();

		for(int i = 0; i < N; i++) {
			boolean flag = false;
			for(int j = i + 1; j < N; j++) {
				if(array[j].startsWith(array[i])) {
					flag = true;
					break;
				}
			}
			if(!flag) res++;
		}

		System.out.println(res);
	}



	static void init() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		array =  new String[N];

		sc.nextLine();
		for(int i = 0; i < N; i++) {
			array[i]= sc.nextLine();
		}
		
		Arrays.sort(array, (o1, o2) -> {return o1.length() - o2.length();});
		
		sc.close();
	}

	
}



