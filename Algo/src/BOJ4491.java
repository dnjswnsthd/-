import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ4491 {
	static class Point {
		int y, x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	private static int minMove;
	private static int[][] distance;
	private static Point[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer stt = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(stt.nextToken());
			int H = Integer.parseInt(stt.nextToken());
			if (W == 0 && H == 0)
				break;
			char[][] map = new char[H][W];
			list = new Point[11];
			int dust_cnt = 1;
			for (int i = 0; i < H; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = input[j];
					if (input[j] == 'o') {
						list[0] = new Point(i, j);
					} else if (input[j] == '*') {
						list[dust_cnt++] = new Point(i, j);
					}
				}
			}
			process(map, W, H, dust_cnt);
			System.out.println(minMove);
		}
	}
	private static void process(char[][] map, int w, int h, int dust_cnt) {
		minMove = Integer.MAX_VALUE;
		distance = new int[dust_cnt + 1][dust_cnt + 1];
		for (int i = 0; i < dust_cnt; i++) {
			for (int j = i + 1; j < dust_cnt; j++) {
				int res = bfs(map, w, h, list[i], list[j]);
				if (res == -1) {
					minMove = -1;
					return;
				} else {
					distance[i][j] = distance[j][i] = res;
				}
			}
		}
		boolean[] selected = new boolean[dust_cnt];
		permutation(0, 0, 0, dust_cnt, selected);
	}
	private static void permutation(int idx, int cnt, int sum, int dust_cnt, boolean[] selected) {
		if (cnt == dust_cnt - 1) {
			minMove = minMove < sum ? minMove : sum;
			return;
		}
		for (int i = 1; i < dust_cnt; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			permutation(i, cnt + 1, sum + distance[idx][i], dust_cnt, selected);
			selected[i] = false;
		}
	}
	private static int bfs(char[][] map, int w, int h, Point src, Point dest) {
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		boolean[][] visited = new boolean[h][w];
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(src);
		visited[src.y][src.x] = true;
		map[src.y][src.x] = '.';

		int move = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point current = queue.poll();
				int y = current.y;
				int x = current.x;
				if (y == dest.y && x == dest.x) {
					return move;
				}
				for (int d = 0; d < 4; d++) {
					int next_y = y + dy[d];
					int next_x = x + dx[d];
					if (outRange(next_y, next_x, w, h) || 
						visited[next_y][next_x] || 
						map[next_y][next_x] == 'x')
						continue;
					queue.offer(new Point(next_y, next_x));
					visited[next_y][next_x] = true;
				}
			}
			move++;
		}
		return -1;
	}
	private static boolean outRange(int next_y, int next_x, int w, int h) {
		return next_y < 0 || next_y >= h || next_x < 0 || next_x >= w;
	}
}