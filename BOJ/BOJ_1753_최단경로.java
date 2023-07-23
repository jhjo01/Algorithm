package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_1753_최단경로
{
		static class Node 
		{
			int vertex, weight;
			Node next;
			public Node(int vertex, int weight, Node next) {
				super();
				this.vertex = vertex;
				this.weight = weight;
				this.next = next;
			}
		}
		
		
		public static void main(String[] args) throws IOException
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(in.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(in.readLine());
			
			Node[] adjList = new Node[V+1];
			
			for(int i = 0; i < E; i++)
			{
				st = new StringTokenizer(in.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to, weight, adjList[from]);
			}
			
			int start = S; 
			
			int[] D = new int[V+1]; 
			boolean[] visited = new boolean[V+1]; 
			
			Arrays.fill(D, Integer.MAX_VALUE); 
			
			D[start] = 0;
			int min, minVertex;
			
			for(int i = 1; i <= V; i++) 
			{
				min = Integer.MAX_VALUE;
				minVertex = -1;
				
				for(int j = 1; j <= V; j++)
				{
					if(!visited[j] && min > D[j])
					{
						min = D[j];
						minVertex = j;
					}
				}
				
				if(minVertex == -1)
				{
					continue;
				}
				else visited[minVertex] = true;
				
				for(Node temp = adjList[minVertex]; temp != null; temp = temp.next)
				{
					if(!visited[temp.vertex] && D[temp.vertex] > temp.weight + D[minVertex])
					{
						D[temp.vertex] = temp.weight + D[minVertex];
					}
				}
			}
			
			for(int i = 1; i <= V; i++)
			{
				if(D[i] == Integer.MAX_VALUE) System.out.println("INF");
				else System.out.println(D[i]);
			}
	}
}
