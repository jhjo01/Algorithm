import java.util.*;

public class Battle {
	static int L, N, Q;
	static int[][] map, trap;
	static Knight[] knight;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Knight {
		int r, c, h, w, hp, dmg;
		boolean isAlive;
		
		public Knight(int r, int c, int h, int w, int hp) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.w = w;
			this.hp = hp;
			this.isAlive = true;
			this.dmg = 0;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 입력
		init(sc);
		
		// 2. Q만큼 기사 이동
		for(int q = 0; q < Q; q++) {
//			for(int i = 0; i < L; i++) {
//				for(int j = 0; j < L; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			move(sc.nextInt(), sc.nextInt(), true);
		}


		
		
		
		// 생존한 기사들의 받은 대미지의 합
		System.out.println(getSum());
	}
	
	static int getSum() {
		int sum = 0;
		
		for(int i = 1; i <= N; i++) {
			if(!knight[i].isAlive) continue;
			sum = sum + knight[i].dmg;
		}
		
		return sum;
	}

	static void init(Scanner sc) {
		L = sc.nextInt(); // map 크기
		N = sc.nextInt(); // 기사 수
		Q = sc.nextInt(); // 명령 수
		
		map = new int[L][L];
		trap = new int[L][L];
		knight = new Knight[N + 1];
		
		for(int i = 0; i < L; i++) {
			for(int j = 0; j < L; j++) {
				int temp = sc.nextInt();
				if(temp == 1) trap[i][j] = temp;
				else map[i][j] = temp * -1;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			// r, c, h, w, k
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			knight[i] = new Knight(r, c, h, w, sc.nextInt());
			
			add(i);
		}
	}
	
	static void move(int id, int dir, boolean first) {
		if(!knight[id].isAlive) return; // 이미 소멸된 기사
		
		// 이동방향에 벽이나 다른 기사가 있는지 확인
		Set<Integer> set = new HashSet<>();
		boolean isCheck = check(id, dir, set);
		if(!isCheck) return;
		
		// 이동 가능하면 여기까지옴
		Iterator<Integer> iter = set.iterator();
		
		while(iter.hasNext()) {
			int i = iter.next();
			remove(i);
			knight[i].r = knight[i].r + dr[dir]; 
			knight[i].c = knight[i].c + dc[dir]; 
		}
		
		iter = set.iterator();
		
		while(iter.hasNext()) {
			int i = iter.next();
			if(i == id) {
				add(i);
				continue;
			}
			
			int sum = 0;
			
			for(int j = knight[i].r; j < knight[i].r + knight[i].h; j++) {
				for(int k = knight[i].c; k < knight[i].c + knight[i].w; k++) {
					sum = sum + trap[j][k];
				}
			}
			
			knight[i].hp = knight[i].hp - sum;
			knight[i].dmg = knight[i].dmg + sum;
			if(knight[i].hp < 1) {
				knight[i].isAlive = false;
				continue;
			}
			
			add(i);
		}
		
	}
	
	static boolean check(int id, int dir, Set<Integer> set) {
		int sr = 0;
		int sc = 0;
		int er = 0;
		int ec = 0;
		int iter = 0;
		
		switch (dir) {
		case 0: // 상
			sr = knight[id].r;
			sc = knight[id].c;
			er = sr;
			ec = knight[id].c + knight[id].w;
			iter = knight[id].w;
			break;
		case 1: // 우
			sr = knight[id].r;
			sc = knight[id].c + knight[id].w - 1;
			er = knight[id].r + knight[id].h;
			ec = sc;
			iter = knight[id].h;
			break;
		case 2: // 하
			sr = knight[id].r + knight[id].h - 1;
			sc = knight[id].c;
			er = sr;
			ec = knight[id].c + knight[id].w;
			iter = knight[id].w;
			break;
		case 3: // 좌
			sr = knight[id].r;
			sc = knight[id].c;
			er = knight[id].r + knight[id].h;
			ec = sc;
			iter = knight[id].h;
			break;
		}
		
		if(sr + dr[dir] < 0 || sr + dr[dir] >= L || sc + dc[dir] < 0 || sc + dc[dir] >= L) return false;
		// 0 2 => c++
		// 1 3 => r++
		// r -1 0 1  0
		// c  0 1 0 -1
		int nr = sr + dr[dir];
		int nc = sc + dc[dir];
		for(int i = 0; i < iter; i++) {
			if(map[nr][nc] < 0) return false;
			if(map[nr][nc] > 0)
				if(!check(map[nr][nc], dir, set)) return false;
			
			if(dir % 2 == 0) nc++;
			else nr++;
				
//			nr = nr + dr[dir];
//			nc = nc + dc[dir];
			
		}

		set.add(id);
		
		return true;
	}
	
	static void add(int id) {
		for(int j = knight[id].r; j < knight[id].r + knight[id].h; j++) {
			for(int k = knight[id].c; k < knight[id].c + knight[id].w; k++) {
				map[j][k] = id;
			}
		}
	}
	
	static void remove(int id) {
		for(int j = knight[id].r; j < knight[id].r + knight[id].h; j++) {
			for(int k = knight[id].c; k < knight[id].c + knight[id].w; k++) {
				map[j][k] = 0;
			}
		}
	}
	
}


// L x L 크기의 체스판에서 대결
// 빈칸 / 함정 / 벽  // 체스판 밖도 벽으로 간주
// 기사는 좌측 상당 좌표를 기준으로 h x w 크기의 직사각형 형태

// 1. 기사 이동
// 왕에게 명령을 받은 기사는 상하좌우 중 하나로 한칸 이동
// 이동하려는 위치에 다른 기사가  있으면 그 기사도 밀어냄
// 옆에 또 기사가 있으면 연쇄적으로 밀어냄
// 밀어내는 방향에 벽이 있다면 못밀음
// 체스판에서 사라진 기사에게 명령하면 아무반응 x

// 2. 대결 데미지
// 밀려난 기사들은 밀려난 후 자신의 범위 안에 있는 함정의 수 만큼 피해를 입음
// 현재 체력 이상의 대미지를 받으면 체스판에서 사라짐
// 단 명령을 받은 기사는 피해를 입지 않음

// Q번에 걸친 왕의 명령이 지난 뒤 생존한 기사들이 받은 대미지의 합 