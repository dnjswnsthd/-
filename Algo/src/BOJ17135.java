import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Archer {
	int y;
	int x;

	Archer(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
class Enemy implements Comparable<Enemy> {
	int y;
	int x;
	int distance;
	Enemy(int y, int x, int distance) {
		this.y = y;
		this.x = x;
		this.distance = distance;
	}
	@Override
	public int compareTo(Enemy target) {
		if (this.distance < target.distance) {
			return -1;
		} 
		else if (this.distance > target.distance) {
			return 1;
		} 
		else { // 같은 경우 
			if (this.x < target.x) { 
				return -1; 
			}
			else if (this.x == target.x) {
				return 0; 
			}
			else {
				return 1;
			}
		}
	}
}
public class BOJ17135 {
	static int ANSWER = 0;
	static int N;
	static int M;
	static int D;
	static int[][] MAP;
	static boolean[] VISITED;
	static Queue <Enemy> que_1 = new LinkedList<Enemy>();
	static Queue <Archer> que_2 = new LinkedList<Archer>();
	static PriorityQueue <Enemy> pque = new PriorityQueue<Enemy>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		MAP = new int[N + 1][M];
		VISITED = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setPosition(0,0);
		System.out.println(ANSWER);
	}
	public static Integer calDistance(int y1, int x1, int y2, int x2) {
		int distance = Math.abs(y1 - y2) + Math.abs(x1 - x2);
		return distance;
	}
	public static int findEnemy() {
		int count = 0; 
		for(int i= 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (MAP[i][j] == 1) {
					que_1.add(new Enemy(i, j, 0));
				}
			}
		}
		while(!que_1.isEmpty()) {
			int[][] TEMPENEMY  = new int[N][M];
			LinkedList <Enemy> list = new LinkedList<Enemy>(); 		
			for(Archer archar : que_2) {
				for(Enemy enemy : que_1) {
					int r = enemy.y;
					int c = enemy.x;
					int distance = calDistance(r, c, archar.y, archar.x);
					if ( distance <= D ) {
						pque.add(new Enemy(r,c,distance));
					}
				}
				if(!pque.isEmpty()) {
					Enemy enemy = pque.poll();
					list.add(new Enemy(enemy.y, enemy.x, enemy.distance)); //죽일 enemy 들 
					pque.clear(); 
				}
			} 
			for(int i = 0; i < list.size(); i++ ) {
				Enemy e = list.get(i);
				TEMPENEMY[e.y][e.x] += 1;
				if( TEMPENEMY[e.y][e.x] == 1) {
					count += 1;
				}
			}
			int qsize = que_1.size();
			for(int s = 0; s < qsize; s++) {
				Enemy e = que_1.poll();
				boolean flag = false;
				for(Enemy enemy : list) {
					if(enemy.y == e.y && enemy.x ==  e.x ) { 
						flag = true;
					}
				}
				if(!flag) {
					que_1.add(e);
				}
			}
			move();
		}
		return count;
	}
	public static boolean isRange(int yid) {
		if (yid == N) {
			return true;
		} else {
			return false;
		}
	}
	public static void move() {
		int qsize = que_1.size();
		for(int s = 0; s < qsize; s++) {
			Enemy enemy = que_1.poll(); 
			int yid = enemy.y + 1;
			int xid = enemy.x;
			int distance = enemy.distance;
			if(isRange(yid)) { 
				continue;
			}else {
				que_1.add(new Enemy(yid, xid, distance));
			}
		}
	}
	public static void setPosition(int depth, int start ) {
		if (depth == 3) {
			for(int i = 0; i < M; i++) {
				if(VISITED[i]) {
					que_2.add(new Archer(N, i));
				}
			}
			int tmpans = findEnemy();
			ANSWER = Math.max(ANSWER, tmpans);
			que_2.clear();
			return;
		}
		for (int i = start; i < M; i++) {
			if (!VISITED[i]) {
				VISITED[i] = true;
				setPosition(depth + 1, i);
				VISITED[i] = false;
			}
		}
	}
}
