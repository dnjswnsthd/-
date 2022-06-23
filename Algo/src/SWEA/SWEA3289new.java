package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289new {
	static int n;
	static int[] parents;

	private static void make() {
		for (int i = 0; i < n + 1; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); 
			int m = Integer.parseInt(st.nextToken()); 

			parents = new int[n + 1];
			make();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int k = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (k == 0) {
					union(a, b);
				} else if (k == 1) {
					if (find(a) == find(b)) {
						sb.append(1);
					} else
						sb.append(0);
				}
			}
			sb.append("\n");

		}

		System.out.println(sb);
		br.close();
	}

}
