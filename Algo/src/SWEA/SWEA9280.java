package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * SWEA 9280 진용이네 주차타워
 * 22.06.26
 */
public class SWEA9280 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			int res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] R = new int[n];
			int[] park = new int[n];
			int[] W = new int[m + 1];
			LinkedList<Integer> move = new LinkedList<>();
			LinkedList<Integer> wait = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				R[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 1; i <= m; i++) {
				W[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 0; i < 2 * m; i++) {
				move.add(Integer.parseInt(br.readLine()));
			}
			int now = 0;
			int front = 0;
			while (!move.isEmpty()) {
				now = move.poll();
				if (now > 0) {
					wait.add(now);
					front = wait.peek();
					for (int i = 0; i < n; i++) {
						if (park[i] == 0) {
							park[i] = front;
							res += R[i] * W[front];
							wait.poll();
							break;
						}
					}
				} else {
					now = -now;
					for (int i = 0; i < n; i++) {
						if (park[i] == now) {
							park[i] = 0;
							if (!wait.isEmpty()) {
								now = wait.poll();
								park[i] = now;
								res += R[i] * W[now];
							}
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}
}