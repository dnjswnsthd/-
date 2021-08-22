package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2644 {
	static int n, m;
	static int num_1, num_2;
	static int[][] map;
	static int depth;
	static boolean[] visited;
	static int res;
	static boolean chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		num_1 = Integer.parseInt(st.nextToken());
		num_2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			map[tmp1][tmp2] = map[tmp2][tmp1] = 1;
		}
		visited = new boolean[n + 1];
		visited[num_1] = false;
		DFS(num_1, depth);
		if(chk) {
			System.out.println(res);
		}else {
			System.out.println(-1);
		}
	}

	private static void DFS(int st1, int depth) {
		if (chk) {
			return;
		} else {
			for (int i = 1; i <= n; i++) {
				if (map[st1][i] == 1 && !visited[i]) {
					if (i == num_2) {
						res = depth+1;
						chk = true;
					}
					visited[i] = true;
					DFS(i, depth + 1);
				}
			}
		}
	}

}
