package day0804;

import java.util.Scanner;
import java.util.Stack;


public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			String data = sc.nextLine();
			Stack<String> stack = new Stack<>();
			
			for(int i = 0; i < N; i++)
			{
				if(stack.isEmpty())
				{
					stack.push(data.charAt(i) + "");
					continue;
				}
				else if((stack.peek().equals("[") && (data.charAt(i) == ']')) ||
						(stack.peek().equals("(") && (data.charAt(i) == ')')) ||
						(stack.peek().equals("{") && (data.charAt(i) == '}')) ||
						(stack.peek().equals("<") && (data.charAt(i) == '>'))
						)
				{
					stack.pop();
					continue;
				}
				stack.push(data.charAt(i) + "");
			}
			
			if(stack.isEmpty()) System.out.println("#" + test_case + " " + 1);
			else System.out.println("#" + test_case + " " + 0);
			
		}
	}
}
