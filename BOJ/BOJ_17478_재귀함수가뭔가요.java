package com.ssafy.recur;

import java.util.Scanner;

public class BOJ_17478_재귀함수가뭔가요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		String[] st = new String[5];
		st[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		st[1] = "\"재귀함수가 뭔가요?\"";
		st[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		st[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		st[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		
		System.out.println(st[0]);
		recu(st, 0, num);
		
	}
	
	public static void recu(String[] st, int cnt, int num)
	{
		if(num == 0)
		{
			for(int j = 0; j < cnt; j++)
			System.out.print("____");
			System.out.println("\"재귀함수가 뭔가요?\"");
			for(int j = 0; j < cnt; j++)
			System.out.print("____");
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			for(int j = 0; j < cnt; j++)
			System.out.print("____");
			System.out.println("라고 답변하였지.");
			return;
		}
		
		for(int i = 1; i < st.length; i++)
		{
			for(int j = 0; j < cnt; j++)
			System.out.print("____");
			System.out.println(st[i]);
		}
		recu(st, cnt+1, num-1);
		for(int j = 0; j < cnt; j++)
		System.out.print("____");
		System.out.println("라고 답변하였지.");
		return;
	}
}

