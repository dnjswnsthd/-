import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {
	private static int n;
	private static int [][] map;
	private static int [][] visited;
	private static int [] dx = {1, 0, -1, 0};
	private static int [] dy = {0, 1, 0 ,-1};
	private static Shark shark;
	private static Queue <Point> que;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i, j);
					map[i][j] = 0;
				}
			}
		}
		int sum = 0, cnt = 1;
		while(cnt > 0) {
			cnt = bfs();
			if(cnt > 0) sum += cnt;
		}
		System.out.println(sum);
	}

	private static int bfs() {
		visited = new int[n][n];
		que = new LinkedList <Point> ();
		que.offer(new Point(shark.x, shark.y));
		visited[shark.x][shark.y]= 1;
		int fishChk = 0;
		Shark fish = new Shark(n, n);
		loop:while(!que.isEmpty()) {
			int x = que.peek().x;
			int y = que.poll().y;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				//이동 가능 : 범위 안이고, 자신보다 큰 물고기 없어야 됨
				if(0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0 && map[nx][ny] <= shark.level) {
					visited[nx][ny] = visited[x][y] + 1;
					que.offer(new Point(nx, ny));
					//위치가 더 커지면 확인할 필요 없음
					if(fishChk != 0 && fishChk < visited[nx][ny]) break loop;
					//처음 먹을 수 있는 물고기 발견
					if(0 < map[nx][ny] && map[nx][ny] < shark.level && fishChk == 0) {
						fishChk = visited[nx][ny];
						fish.x = nx;
						fish.y = ny;
						fish.level = map[nx][ny];
					}else if(fishChk == visited[nx][ny] && 0 < map[nx][ny] && map[nx][ny] < shark.level) {//같은 위치에 여러 마리 있을 때, 가장 위의 가장 왼쪽 부터 먹는다.
						if(nx < fish.x) {//가장 위
							fish.x = nx;
							fish.y = ny;
							fish.level = map[nx][ny];
						}else if (nx == fish.x && ny < fish.y) {//왼쪽
							fish.x = nx;
							fish.y = ny;
							fish.level = map[nx][ny];
						}
					}
				}else if(0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0) visited[nx][ny] = -1;
			}
		}
		if(fish.x != n && fish.y != n) {
			//작은 크기의 물고기만 먹을 수 있다.
			shark.x = fish.x;
			shark.y = fish.y;
			map[fish.x][fish.y] = 0;//물고기 죽인다.
			shark.cnt_eat++;//먹은 수 카운트
			if(shark.level < 7 && shark.cnt_eat == shark.level) {
				//자신의 크기만큼 물고기 먹으면 성장
				shark.cnt_eat = 0;
				shark.level++;
			}
		}
		return fishChk -1;
	}
}
class Shark{
	int x, y;
	int level;
	int cnt_eat;
	public Shark(int x, int y) {
		this.x = x;
		this.y = y;
		this.cnt_eat = 0;
		this.level = 2;
	}
}
