package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA 7988. 내전 경기
 * 22.06.27
 */
public class SWEA7988 {
	static Map<String, Integer> map;
	static boolean[] chk;
	static List<Integer>[] list;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int k = Integer.parseInt(br.readLine());
			int cnt = 0;
			map = new HashMap<>();
			chk = new boolean[201];
			arr = new int[201];
			list = new List[201];
			for (int i = 0; i < 201; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String pair1 = st.nextToken();
				String pair2 = st.nextToken();
				if (!map.containsKey(pair1)) {
					map.put(pair1, cnt);
					cnt++;
				}
				if (!map.containsKey(pair2)) {
					map.put(pair2, cnt);
					cnt++;
				}
				list[map.get(pair1)].add(map.get(pair2));
				list[map.get(pair2)].add(map.get(pair1));
			}
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);
			arr[0] = -1;
			chk[0] = true;
			boolean res = true;
			loop:while (!q.isEmpty()) {
				int tmp = q.poll();
				int p = arr[tmp];
				for (int i = 0; i < list[tmp].size(); i++) {
					if (arr[list[tmp].get(i)] == p) {
						res = false;
						break loop;
					}
					if (!chk[list[tmp].get(i)]) {
						chk[list[tmp].get(i)] = true;
						arr[list[tmp].get(i)] = -p;
						q.add(list[tmp].get(i));
					}
				}
			}
			if(res) System.out.println("#" + t + " " + "Yes");
			else System.out.println("#" + t + " " + "No");
		}
	}
}
