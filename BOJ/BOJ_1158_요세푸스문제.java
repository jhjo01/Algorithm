package day0808;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> data = new LinkedList<>();
		
		for(int i = 0; i < N; i++)
		{
			data.add(i+1);
		}
		
		sb.append("<");
		int cnt = 0;
		while(!data.isEmpty())
		{
			cnt++;
			if(cnt == K)
			{
				sb.append(data.poll());
				if(!data.isEmpty()) sb.append(", ");
				cnt = 0;
			}
			else data.add(data.poll());
		}

		sb.append(">");
		
		System.out.println(sb);
		
	}
}
