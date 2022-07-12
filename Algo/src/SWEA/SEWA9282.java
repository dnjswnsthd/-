package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SEWA9282 {
	static int result;
	static int N, M;
	static int[][] map;
	static int[][][][] dp;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			dp = new int[N + 1][M + 1][N + 1][M + 1];

			for (int[][][] d1 : dp) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			result = dfs(0, 0, N, M);

			System.out.println("#" + tc + " " + result);
		}
	}

	public static int dfs(int y, int x, int h, int w) {
		if (w == 1 && h == 1) {
			return 0;
		}
		int sum = 0;
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
			for (int i = 1; i < h; i++) {
				if (dp[y][x][i][w] == Integer.MAX_VALUE) {
					dp[y][x][i][w] = dfs(y, x, i, w);
				}
				if (dp[y + i][x][h - i][w] == Integer.MAX_VALUE) {
					dp[y + i][x][h - i][w] = dfs(y + i, x, h - i, w);
				}
				int sum3 = sum + dp[y][x][i][w] + dp[y + i][x][h - i][w];
				dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
			}
			for (int i = 1; i < w; i++) {
				if (dp[y][x][h][i] == Integer.MAX_VALUE) {
					dp[y][x][h][i] = dfs(y, x, h, i);
				}
				if (dp[y][x + i][h][w - i] == Integer.MAX_VALUE) {
					dp[y][x + i][h][w - i] = dfs(y, x + i, h, w - i);
				}
				int sum3 = sum + dp[y][x][h][i] + dp[y][x + i][h][w - i];
				dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
			}
			return dp[y][x][h][w];
		}

	}
}
