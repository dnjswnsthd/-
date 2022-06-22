package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 2814 최장경로
 * 22.06.22
 */
public class SWEA2814 {
	static int res, n, m;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			res = 0;
			map = new int[n + 1][n + 1];
			visited = new boolean[n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
				map[y][x] = 1;
			}
			for (int i = 1; i <= n; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + t + " " + res);
		}
	}

	public static void dfs(int index, int cnt) {
		if (res < cnt) res = cnt;
		for (int j = 1; j <= n; j++) {
			if (map[index][j] == 1 && visited[j] == false) {
				visited[j] = true;
				dfs(j, cnt + 1);
				visited[j] = false;
			}
		}
	}
}
