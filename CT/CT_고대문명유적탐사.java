import java.util.*;

public class AncientRuinExloration {
	static final int MAP_SIZE = 5;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int K, M, score;
	static int[][] map;
	static List<Integer> relicList;
	
	public static void main(String[] args) {
		// 1. 입력
		init();
		// 2. 	3x3으로 돌면서 최고점수 위치 확인
		// 3.	3개 이상 연결되는 유물 찾기 
		// 4. 	최고점수 위치의 유물들 없애기
		// 5.	없어진 유물들 채워넣기
		// 6.	3개 이상 연결되는 유물 찾기
		for(int i = 0; i < K; i++) {
			score = 0;
			rotate();
			fillRelic();
			while(checkAndGetRelic(map, 0) >= 3) {
				fillRelic();
			}
			if(score == 0) break;
			System.out.print(score + " ");
		}
		
	}
	
	static void init() {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); 
		M = sc.nextInt();
		map = new int[MAP_SIZE][MAP_SIZE];
		relicList = new ArrayList<>();
		score = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < M; i++) {
			relicList.add(sc.nextInt());
		}
		
		sc.close();
	}
	
	static void rotate() {
		// 1순위 유물 가치
		// 2순위 회전한 각도가 작은 방법
		// 3순위 회전 중심 좌표의 열이 가장 작은 구간 열이 같다면 행이 가장 작은 구간
		int maxValue = 0;
		int maxR = 0;
		int maxC = 0;
		int maxDegree = 0;
		
		// 90도 rotate90(map, r, c)
		// 180도 rotate90(rotate90(map, r, c), r, c)
		// 270도 rotate90(rotate90(rotate90(map, r, c), r, c), r, c)
		
		for(int i = 1; i < MAP_SIZE - 1; i++) {
			for(int j = 1; j < MAP_SIZE - 1; j++) {
				int[][] tempMap = rotate90(map, i, j);
				int value = checkAndGetRelic(tempMap, 1);
				if(compareRelic(maxValue, maxR, maxC, maxDegree, value, i, j, 90)) {
					maxValue = value;
					maxR = i;
					maxC = j;
					maxDegree = 90;
				}
				
				tempMap = rotate90(rotate90(map, i, j), i, j);
				value = checkAndGetRelic(tempMap, 1);
				if(compareRelic(maxValue, maxR, maxC, maxDegree, value, i, j, 180)) {
					maxValue = value;
					maxR = i;
					maxC = j;
					maxDegree = 180;
				}
				
				tempMap = rotate90(rotate90(rotate90(map, i, j), i, j), i, j);
				value = checkAndGetRelic(tempMap, 1);
				if(compareRelic(maxValue, maxR, maxC, maxDegree, value, i, j, 270)) {
					maxValue = value;
					maxR = i;
					maxC = j;
					maxDegree = 270;
				}
			}
		}
		
		if(maxDegree == 90) {
			int[][] tempMap = rotate90(map, maxR, maxC);
			checkAndGetRelic(tempMap, 0);
		} else if (maxDegree == 180) {
			int[][] tempMap = rotate90(rotate90(map, maxR, maxC), maxR, maxC);
			checkAndGetRelic(tempMap, 0);
		} else if(maxDegree == 270) {
			int[][] tempMap = rotate90(rotate90(rotate90(map, maxR, maxC), maxR, maxC), maxR, maxC);
			checkAndGetRelic(tempMap, 0);
		}
	}
	
	static boolean compareRelic(int maxValue, int maxR, int maxC, int maxDegree, int value, int r, int c, int degree) {
		// 새로운 값이 더 크면 true 반환
		if(value > maxValue) return true;
		else if(value == maxValue)
			if(degree < maxDegree) return true;
			else if(degree == maxDegree)
				if(c < maxC) return true;
				else if(c == maxC)
					if(r < maxR) return true;
		return false;
	}
	
	static int checkAndGetRelic(int[][] map, int type) {
		boolean visitedMap[][] = new boolean[MAP_SIZE][MAP_SIZE];
		int value = 0;
		
		for(int i = 0; i < MAP_SIZE; i++) {
			for(int j = 0; j < MAP_SIZE; j++) {
				Queue<int[]> queue = new ArrayDeque<>();
				List<int[]> list = new ArrayList<>();
				int cnt = 0;
				if(!visitedMap[i][j]) {
					queue.offer(new int[] {i, j});
					visitedMap[i][j] = true;
					cnt++;
					list.add(new int[] {i, j});
				}
				
				while(!queue.isEmpty()) {
					int[] temp = queue.poll();
					int r = temp[0];
					int c = temp[1];
					
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr < 0 || nr >= MAP_SIZE || nc < 0 || nc >= MAP_SIZE || visitedMap[nr][nc] || map[r][c] != map[nr][nc]) continue;
						
						queue.offer(new int[] {nr, nc});
						visitedMap[nr][nc] = true;
						cnt++;
						list.add(new int[] {nr, nc});
					}
				}
				
				if(cnt >= 3) {
					value = value + cnt;
					while(!list.isEmpty()) {
						int[] temp = list.remove(0);
						map[temp[0]][temp[1]] = 0;
					}
				}
			}
		}
		
		if(type == 0) {
			AncientRuinExloration.map = map;
			score = score + value;
		}
		
		return value;
	}
	
	
	static void fillRelic() {
		for(int i = 0; i < MAP_SIZE; i++) {
			for(int j = MAP_SIZE - 1; j >= 0; j--) {
				if(map[j][i] == 0) {
					map[j][i] = relicList.remove(0);
				}
			}
		}
	}
	
	static int[][] rotate90(int[][] map, int r, int c) {
		//j, n - 1 - i = i, j
		int[][] copyMap = deepCopy(map);
		
		copyMap[r - 1][c - 1] = map[r + 1][c - 1];
		copyMap[r - 1][c] = map[r][c - 1];
		copyMap[r - 1][c + 1] = map[r - 1][c - 1];
		copyMap[r][c - 1] = map[r + 1][c];
		copyMap[r][c + 1] = map[r - 1][c];
		copyMap[r + 1][c - 1] = map[r + 1][c + 1];
		copyMap[r + 1][c] = map[r][c + 1];
		copyMap[r + 1][c + 1] = map[r - 1][c + 1];
		
		return copyMap;
	}
	
	static int[][] deepCopy(int[][] map) {
		int[][] copy = new int[MAP_SIZE][MAP_SIZE];
		
		for(int i = 0; i < MAP_SIZE; i++) {
			for(int j = 0; j < MAP_SIZE; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
	}

}
