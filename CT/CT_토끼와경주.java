import java.util.*;


class Rabbit implements Comparable<Rabbit>{
	int x;
	int y;
	int id;
	int dist;
	int count;
	long score;
	boolean isSelected;
	
	Rabbit(int id, int dist) {
		this.id = id;
		this.dist = dist;
		x = y = 1;
		score = count = 0;
		isSelected = false;
	}
	
	@Override
	public int compareTo(Rabbit o) {
		if(this.count == o.count) {
			if((this.x + this.y) == (o.x + o.y) ) {
				if(this.x == o.x) {
					if(this.y == o.y) {
						return this.id - o.id;
					}
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return (this.x + this.y) - (o.x + o.y);
		}
		return this.count - o.count;
	}
}

class Destination implements Comparable<Destination> {
	int x;
	int y;
	
	public Destination(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Destination o) {
		if((o.x + o.y) == (this.x + this.y)) {
			if(o.x == this.x) {
				return o.y - this.y;
			}
			return o.x - this.x;
		}
		return (o.x + o.y) - (this.x + this.y);
	}
}

public class 토끼 {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static List<Rabbit> rabbitList = new ArrayList<>();
	
	public static void main(String[] args) {
		int q = sc.nextInt();
		
		for(int tc = 0; tc < q; tc++) {
			switch(sc.nextInt()) {
				case 100:
					init();
					break;
				case 200:
					run();
					break;
				case 300:
					changeDist();
					break;
				case 400:
					getBestRabbit();
					break;
			}
		}
		
	}
	private static void getBestRabbit() {
		long max = 0;
		for(int i = 0; i < rabbitList.size(); i++) {
			max = Math.max(max, rabbitList.get(i).score);
		}
		System.out.println(max);
	}
	private static void changeDist() {
		int pid_t = sc.nextInt();
		int l = sc.nextInt();
		
		for(int i = 0; i < rabbitList.size(); i++) {
			Rabbit rabbit = rabbitList.get(i);
			if(rabbit.id == pid_t) {
				rabbit.dist = rabbit.dist * l;
			}
		}
		
	}
	
	private static void run() {
		int k = sc.nextInt();
		int s = sc.nextInt();
		
		for(int i = 0; i < rabbitList.size(); i++) {
			rabbitList.get(i).isSelected = false;
		}
		
		for(int i = 0; i < k; i++) {
			Collections.sort(rabbitList);
			Rabbit rabbit = rabbitList.get(0);
			rabbit.isSelected = true;
			rabbit.count = rabbit.count + 1;
			
			List<Destination> destinationList = new ArrayList<>();
			destinationList.add(getUp(rabbit));
			destinationList.add(getDown(rabbit));
			destinationList.add(getLeft(rabbit));
			destinationList.add(getRight(rabbit));
			Collections.sort(destinationList);
			
			int desX = destinationList.get(0).x;
			int desY = destinationList.get(0).y;
			
			rabbit.x = desX;
			rabbit.y = desY;
			
			for(int j = 1; j < rabbitList.size(); j++) {
				rabbitList.get(j).score = rabbitList.get(j).score + rabbit.x + rabbit.y; 
			}
		}
		
		Collections.sort(rabbitList, (o1, o2) -> {
			if((o1.x + o1.y) == (o2.x + o2.y) ) {
				if(o1.x == o2.x) {
					if(o1.y == o2.y) {
						return o2.id - o1.id;
					}
					return o2.y - o1.y;
				}
				return o2.x - o1.x;
			}
			return (o2.x + o2.y) - (o1.x + o1.y);
		});
		
		for(int i = 0; i < rabbitList.size(); i++) {
			if(rabbitList.get(i).isSelected) {
				rabbitList.get(i).score += s;
				break;
			}
		}
	}
	private static Destination getRight(Rabbit rabbit) {
		int x = rabbit.x;
		int y = rabbit.y;
		int dist = rabbit.dist % ((m -1) * 2);
		
		if(dist >= m - y) {
			dist = dist - (m - y);
			y = m;
		} else {
			y = y + dist;
			dist = 0;
		}
		
		if(dist >= y - 1) {
			dist = dist - (y - 1);
			y = 1;
		} else {
			y = y - dist;
			dist = 0;
		}
		
		y = y + dist;
		
		return new Destination(x, y);
	}
	private static Destination getLeft(Rabbit rabbit) {
		int x = rabbit.x;
		int y = rabbit.y;
		int dist = rabbit.dist % ((m -1) * 2);
		
		if(dist >= y - 1) {
			dist = dist - (y - 1);
			y = 1;
		} else {
			y = y - dist;
			dist = 0;
		}
		
		if(dist >= m - y) {
			dist = dist - (m - y);
			y = m;
		} else {
			y = y + dist;
			dist = 0;
		}
		
		y = y - dist;
		
		return new Destination(x, y);
	}
	private static Destination getDown(Rabbit rabbit) {
		int x = rabbit.x;
		int y = rabbit.y;
		int dist = rabbit.dist % ((n -1) * 2);
		
		if(dist >= n - x) {
			dist = dist - (n - x);
			x = n;
		} else {
			x = x + dist;
			dist = 0;
		}
		
		if(dist >= x - 1) {
			dist = dist - (x - 1);
			x = 1;
		} else {
			x = x - dist;
			dist = 0;
		}
		
		x = x + dist;
		
		return new Destination(x, y);
	}
	private static Destination getUp(Rabbit rabbit) {
		int x = rabbit.x;
		int y = rabbit.y;
		int dist = rabbit.dist % ((n -1) * 2);
		
		if(dist >= x - 1) {
			dist = dist - (x - 1);
			x = 1;
		} else {
			x = x - dist;
			dist = 0;
		}
		
		if(dist >= n - x) {
			dist = dist - (n - x);
			x = n;
		} else {
			x = x + dist;
			dist = 0;
		}
		
		x = x - dist;
		
		return new Destination(x, y);
	}
	private static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		int p = sc.nextInt();
		
		for(int i = 0; i < p; i++) {
			rabbitList.add(new Rabbit(sc.nextInt(), sc.nextInt()));
		}
		
	}
}
