package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * SWEA 1258. [S/W 문제해결 응용] 7일차 - 행렬찾기
 * 22.06.20
 */
public class SWEA1258 {
	static int[][] map;
	static int size;
	static int ey, ex;
	static int [] dx = { -1, 0, 1, 0 };
	static int [] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			map = new int[size][size];
			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ArrayList<pair> list = new ArrayList<>();
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (map[i][j] != 0) {
						ey = -1;
						ex = -1;
						dfs(i, j);
						list.add(new pair(ey - i + 1, ex - j + 1));
						cnt++;
					}
				}
			}
			System.out.print("#" + t + " " + cnt);

			list.sort(null);
			for (pair p : list) {
				System.out.print(" " + p.y + " " + p.x);
			}

			System.out.println();
		}
	}

	public static void dfs(int y, int x) {
		map[y][x] = 0; // visit check
		ey = ey < y ? y : ey;
		ex = ex < x ? x : ex;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny > size - 1 || nx < 0 || nx > size - 1 || map[ny][nx] == 0)
				continue;

			dfs(ny, nx);
		}
	}

	static class pair implements Comparable<pair> {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(pair o) {
			int oMul = o.y * o.x;
			int thisMul = this.y * this.x;

			if (oMul == thisMul) {
				return this.y - o.y;
			} else {
				return thisMul - oMul;
			}
		}

	}
}
