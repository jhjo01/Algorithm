package day0822;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_Contact {

	static int N, S, ans;
	static List<Integer>[][] edgeList;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			S = sc.nextInt();
			
			edgeList = new List[101][2];
			visited = new boolean[101];
			for(int i = 0; i < 101; i++)
			{
				edgeList[i][0] = new ArrayList<Integer>();
				edgeList[i][1] = new ArrayList<Integer>();
				edgeList[i][1].add(0);
			}
			
			for(int i = 0; i < N/2; i++)
			{
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				edgeList[from][0].add(to);

			}
			
//			for(List a : edgeList) System.out.println(a);
			
			ans = 0;
			bfs(S);
			
			
			System.out.println("#" + test_case + " " + ans);
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
	
	static void bfs(int i)
	{
		Queue<Integer> q = new ArrayDeque<Integer>();
		int maxDepth = 0;
		visited[i] = true;
		q.offer(i);
		while(!q.isEmpty())
		{
			i = q.poll();
			for(int j = 0; j < edgeList[i][0].size(); j++)
			{
				int temp = edgeList[i][0].get(j);
				if(!visited[edgeList[i][0].get(j)])
				{
					visited[edgeList[i][0].get(j)] = true;
					q.offer(edgeList[i][0].get(j));
//					edgeList[edgeList[i][0].get(j)][1].set(0, edgeList[i][1].get(0) + 1);
					edgeList[edgeList[i][0].get(j)][1].add(edgeList[i][1].get(0) + 1);
					edgeList[edgeList[i][0].get(j)][1].remove(0);
					
				}
			}
			
			maxDepth = Math.max(maxDepth, edgeList[i][1].get(0));
		}
		
		for(int j = 1; j < 101; j++)
		{
			if(edgeList[j][1].get(0) == maxDepth) ans = Math.max(ans, j);
		}
	}
}
