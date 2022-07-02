package SWEA;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2112 {
	static int D, W, K;
	static int[][] map;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int  t= 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			sb.append('#').append(t).append(' ').append(min == Integer.MAX_VALUE ? 0 : min).append('\n');
		}
		System.out.print(sb);
	}
	private static void dfs(int k, int cnt) {
		if (cnt >= min) 
			return;
		if (k == D) {
			loop: for (int i = 0; i < W; i++) {
				int same = 1;
				for (int j = 0; j < D - 1; j++) {
					if (map[j][i] == map[j + 1][i]) {
						same++;
					} else {
						same = 1;
					}
					if (same >= K) {
						continue loop;
					}
				}
				return;
			}
			min = Math.min(min, cnt);
			return;
		}
		int[] tmp = map[k].clone();
		dfs(k + 1, cnt);
		Arrays.fill(map[k], 0);
		dfs(k + 1, cnt + 1);
		Arrays.fill(map[k], 1);
		dfs(k + 1, cnt + 1);
		map[k] = tmp;
	}
}