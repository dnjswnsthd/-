package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * SWEA 1249. [S/W 문제해결 응용] 4일차 - 보급로
 * 22.06.08
 */
public class SWEA1249 {
	static int[][] map;
	static int[][] cost;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int size;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			cost = new int[size][size];
			for (int i = 0; i < size; i++) {
				String str = br.readLine();
				for (int j = 0; j < size; j++) {
					map[i][j] = str.charAt(j) - '0';
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			int res = bfs();

			System.out.println("#" + t + " " + res);
		}
	}

	public static int bfs() {
		PriorityQueue<Dir> q = new PriorityQueue<>();
		q.add(new Dir(0, 0, map[0][0]));
		cost[0][0] = map[0][0];
		while (!q.isEmpty()) {
			Dir d = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if (nx == -1 || nx == size || ny == -1 || ny == size) {
					continue;
				}
				if (cost[nx][ny] > cost[d.x][d.y] + map[nx][ny]) {
					cost[nx][ny] = cost[d.x][d.y] + map[nx][ny];
					q.offer(new Dir(nx, ny, cost[nx][ny]));
				}
			}
		}
		return cost[size - 1][size - 1];
	}
}

class Dir implements Comparable<Dir> {
	int x;
	int y;
	int d;

	Dir(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public int compareTo(Dir dir) {
		return this.d < dir.d ? -1 : 1;
	}
}
