import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7576 {
	private static int n, m;
	private static int [][] map;
	private static int [] dx = {-1, 1, 0, 0};
	private static int [] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		map = new int [m][n];
		for(int i = 0; i < m; i++) {
			String [] data = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(data[j]);
			}
		}
		bfs(m,n);
	}
	private static void bfs(int x, int y) {
		Queue <Pair> que = new LinkedList<>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					que.offer(new Pair(i, j));
				}
			}
		}
		while(!que.isEmpty()) {
			Pair tmp = que.poll();
			for(int j = 0; j < 4; j++) {
				int nx = tmp.x + dx[j];
				int ny = tmp.y + dy[j];
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] == 0) {
					map[nx][ny] = map[tmp.x][tmp.y] + 1;
					que.offer(new Pair(nx, ny));
				}
			}
		}
		int max = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
					
				}else if(max < map[i][j]) max = map[i][j];
			}
		}
		System.out.println(max-1);
	}
	public static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}