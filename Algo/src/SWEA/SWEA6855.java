package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA 6855. 신도시 전기 연결하기
 * 22.06.28
 */
public class SWEA6855 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int res = 0;
			int[] house = new int[n];
			int[] houseDistance = new int[n - 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				house[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < n - 1; i++) {
				houseDistance[i] = house[i + 1] - house[i];
			}
			Arrays.sort(houseDistance);
			for(int i = 0; i < n - k; i++) {
				res += houseDistance[i];
			}
			sb.append("#" + t + " " + res + "\n");
		}
		System.out.println(sb);
	}
}
