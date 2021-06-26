import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ10942 {
	static int[] arr;
	static boolean[][] dp;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		arr = new int[n + 1];
		dp = new boolean[n + 1][n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int ele = Integer.valueOf(st.nextToken());
			arr[i] = ele;
		}
		st = new StringTokenizer(br.readLine());
		int tc = Integer.valueOf(st.nextToken());
		StringBuilder sb = new StringBuilder();
		getDP(n);
		while(tc --> 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			boolean result = dp[s][e];
			if(result) {
				sb.append(1);
			}
			else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static boolean palindrome(int s, int e, int n) {
		int mid = (s + e) / 2;
		for(int i = s; i <= mid; i++) {
			int j = s + e - i;
			int left = arr[i];
			int right = arr[j];
			if(left != right) {
				return false;
			}
		}
		return true;
	}
	private static void getDP(int n) {
		for(int i = 1; i <= n; i++) {
			dp[i][i] = true;
		}
		for(int i = 1; i <= n - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				dp[i][i + 1] = true;
			}
			else {
				dp[i][i + 1] = false;
			}
		}
		for(int i = 3; i <= n; i++) {
			for(int j = 1; j <= n - i + 1; j++) {
				int k = j + i - 1;
				if(arr[j] == arr[k]) {
					if(dp[j + 1][k - 1]) {
						dp[j][k] = true;
					}
				}
			}
		}
	}
}