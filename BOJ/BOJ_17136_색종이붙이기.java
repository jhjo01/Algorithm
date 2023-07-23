package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_17136_색종이붙이기 {
	static int N, size, cnt;
	static int[][] map;
	static ArrayList<ArrayList<Integer>> list;
	static int[] paper;
	static boolean end = false, find;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = 10;
		map = new int[N][N];
		list = new ArrayList<ArrayList<Integer>>();
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 1) {
					ArrayList<Integer> loc = new ArrayList<Integer>();
					loc.add(r);
					loc.add(c);
					list.add(loc);
				}
			}
		}
		
		paper = new int[6];
		paper[1] = 5; paper[2] = 5; paper[3] = 5; paper[4] = 5; paper[5] = 5;
		cnt = 0;
		if(!list.isEmpty()) {
			size = list.size();
			dfs(0);
		}
		
		System.out.println(cnt);
		
	}
	
	static void dfs(int index) {
		if(index == size) {
			end= true;
			return;
		}
		find = true;
		outer : for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					find = false;
					break outer;
				}
			}
		}
		if(find) return;
		int r = list.get(index).get(0);
		int c = list.get(index).get(1);
		
		outer : for(int i = 5; i > 0; i--) {	
			if(paper[i] == 0) continue;	
			
			outer2 : for(int nr = 0; nr < i; nr++) {
				for(int nc = 0; nc < i; nc++) {
					if(map[r][c] == 0) dfs(index+1);
					if(end || find) return;
					if(r+nr >= N || c+nc >= N || map[r+nr][c+nc] == 0) continue outer;
				}
			}

			for(int nr = 0; nr < i; nr++) {
				for(int nc = 0; nc < i; nc++) {
					map[r+nr][c+nc] = 0;
				}
			}
			map[r][c] = 0;
			paper[i]--;
			cnt++;
			dfs(index+1);
			if(end || find) return;

			for(int nr = 0; nr < i; nr++) {
				for(int nc = 0; nc < i; nc++) {
					map[nr][nc] = 1;
				}
			}
			paper[i]++;
			cnt--;
		}
		cnt = -1;
		return;
	}
	
}
