import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2667 {
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	private static int [] dx = {0, 0, -1, 1};
	private static int [] dy = {-1, 1, 0, 0};
	private static int [] apart_size = new int [10000];
	private static int [] tmp;
	private static int size = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String[] apart = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(apart[j]);
			}
		}
		int apart_cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					dfs(i, j); 
					apart_size[apart_cnt] = size; 
					apart_cnt++;
					size = 1;
				}
			}
		}
		System.out.println(apart_cnt);
		tmp = new int[apart_cnt];
		for(int i = 0; i < apart_cnt; i++) {
			tmp[i] = apart_size[i];
		}
		Arrays.sort(tmp);
		for(int i = 0; i < apart_cnt; i++) {
			System.out.println(tmp[i]);
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == false && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				size++;
				dfs(nx, ny);
			}
		}
	}
}
