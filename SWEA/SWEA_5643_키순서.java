package day1011;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_키순서1_BFS {
	static int N, M, adjMatrix[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			adjMatrix = new int[N+1][M+1]; // 학생번호 1부터 처리
			
			for(int m = 0; m < M; m++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adjMatrix[a][b] = 1; // a보다 b가 크다
			}
			
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				if(gtBFS(i) + ltBFS(i) == N-1) ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	static int gtBFS(int start) { // start 학생부터 자신보다 키가 큰 학생따라 탐색
		int cnt = 0; // 나보다 큰 학생 수
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
				if(adjMatrix[cur][i] == 1 && !visited[i]) { // i가 cur보다 키가 크고 아직 탐색되지 않았다면
					cnt++; // 나보다 큰 학생 카운트
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return cnt;
	}
	
	static int ltBFS(int start) { // start 학생부터 자신보다 키가 작은 학생따라 탐색
		int cnt = 0; // 나보다 작은 학생 수
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 1; i <= N; i++) { // 인접행렬에서 자신의 열로 간선정보를 갖고 있는 정점 들여다보기
				if(adjMatrix[i][cur] == 1 && !visited[i]) { // i가 cur보다 키가 작고 아직 탐색되지 않았다면
					cnt++; // 나보다 작은 학생 카운트
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return cnt;
	}
}
