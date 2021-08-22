package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4963 {
	private static int w, h;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			cnt = 0;
			String[] wh = br.readLine().split(" ");
			w = Integer.parseInt(wh[0]);
			h = Integer.parseInt(wh[1]);
			map = new int[h][w];
			visited = new boolean[h][w];
			if (w == 0 && h == 0)
				break;
			for (int i = 0; i < h; i++) {
				String[] data = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(data[j]);
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && visited[i][j] == false) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		for (int x = 0; x < 8; x++) {
			int nx = i + dx[x];
			int ny = j + dy[x];
			if (nx >= 0 && nx < h && ny >= 0 && ny < w && visited[nx][ny] == false && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}
