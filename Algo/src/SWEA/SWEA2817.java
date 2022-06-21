package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA2817 부분수열의 합
 * 22.06.21
 */
public class SWEA2817 {
	static int[] arr;
	static int n;
	static int k;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			permutation(0, 0);
			System.out.println("#" + t + " " + cnt);
		}

	}

	public static void permutation(int index, int sum) {
		if (sum == k) {
			cnt++;
			return;
		}
		if (index == n) {
			return;
		}
		permutation(index + 1, sum + arr[index]);
		permutation(index + 1, sum);
	}
}
