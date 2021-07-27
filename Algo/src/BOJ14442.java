import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442 {
	private static int n, m, k; 
	private static int res = Integer.MAX_VALUE;
	private static int[][] map;
	private static boolean[][][] visited;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[k + 1][n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		bfs();
		if (res == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(res);
	}

	public static void bfs() {
		Queue <Pair> q = new LinkedList<>();
		q.offer(new Pair(0, 0, 1, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (cur.r == n - 1 && cur.c == m - 1) {
				res = Math.min(res, cur.cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.r + dx[i];
				int ny = cur.c + dy[i];

				if (arrange_chk(nx, ny) && !visited[cur.block][nx][ny]) {
					if (map[nx][ny] == 0) {
						q.offer(new Pair(nx, ny, cur.cnt + 1, cur.block));
						visited[cur.block][nx][ny] = true;
					} else if (map[nx][ny] == 1 && cur.block < k) {
						q.offer(new Pair(nx, ny, cur.cnt + 1, cur.block + 1));
						visited[cur.block + 1][nx][ny] = true;
					}
				}
			}
		}

	}

	public static boolean arrange_chk(int row, int col) {
		return (row >= 0 && row < n) && (col >= 0 && col < m);
	}
	public static class Pair {
		int r, c, cnt, block;
		public Pair(int r, int c, int cnt, int block) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.block = block;
		}
	}
}

