package day0825;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1197_최소스패닝트리
{
	static int V, E;
	static Scanner sc = new Scanner(System.in);
	static class Edge
	{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class Node
	{
		int vertext, weight;
		Node next;
		public Node(int vertext, int weight, Node next) {
			super();
			this.vertext = vertext;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex
	{
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args)
	{
		
		
		V = sc.nextInt();
		E = sc.nextInt();
		
//		kruskal();
//		prim();
		pQPrim();
		
		
	}
	
	///////////////////// kruskal
	static int[] parents;
	static Edge[] edgeList;
	static void kruskal()
	{
		edgeList = new Edge[E];
		
		for(int i = 0; i < E; i++)
		{
			edgeList[i] = new Edge(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt());
		}
		
		make();
		Arrays.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);
		
		int result = 0;
		int count = 0;
		for(Edge edge : edgeList)
		{
			if(union(edge.from, edge.to))
			{
				result += edge.weight;
				if(++count == V-1) break;
			}
		}
		System.out.println(result);
	}		
	
	static void make()
	{
		parents = new int[V];
		
		for(int i = 0; i < V; i++)
		{
			parents[i] = i;
		}
	}
	
	static int find(int a)
	{
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b)
	{
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	//////////////////////////// prim
	
	static void prim()
	{
		Node[] adjList = new Node[V];
		
		for(int i = 0; i < E; i++)
		{
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			int weight = sc.nextInt();
			
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		int[] minEdge = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0;
		int result = 0;
		
		for(int c = 0; c < V; c++)
		{
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int i = 0; i < V; i++)
			{
				if(!visited[i] && min > minEdge[i])
				{
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			visited[minVertex] = true;
			result += min;
			
			for(Node temp = adjList[minVertex]; temp != null; temp = temp.next)
			{
				if(!visited[temp.vertext] && minEdge[temp.vertext] > temp.weight)
				{
					minEdge[temp.vertext] = temp.weight;
				}
			}
		}
		System.out.println(result);
	}
	
	/////////////////////// pq prim
	static void pQPrim()
	{
		Node[] adjList = new Node[V];
		
		for(int i = 0; i < E; i++)
		{
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			int weight = sc.nextInt();
			
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		int[] minEdge = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0;
		int result = 0;
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>( (o1, o2) -> o1.weight - o2.weight);
		pQueue.offer(new Vertex(0, minEdge[0]));
		
		int cnt = 0;
		while(!pQueue.isEmpty())
		{
			Vertex minVertex = pQueue.poll();
			
			if(visited[minVertex.no]) continue;
			
			visited[minVertex.no] = true;
			result += minVertex.weight;
			if(++cnt == V) break;
			
			for(Node temp = adjList[minVertex.no]; temp != null; temp = temp.next)
			{
				if(!visited[temp.vertext] && minEdge[temp.vertext] > temp.weight)
				{
					minEdge[temp.vertext] = temp.weight;
					pQueue.offer(new Vertex(temp.vertext, temp.weight));
				}
			}
		}
		System.out.println(result);
	}
}
