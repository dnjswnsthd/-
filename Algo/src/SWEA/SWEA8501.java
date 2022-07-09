package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA8501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int mod = 1000000007;
		long[] factorial = new long[1001];
		factorial[1] = 1;
		factorial[2] = 2;
		for (int i = 3; i <= 1000; i++) {
			factorial[i] = i * factorial[i - 1];
			factorial[i] %= mod;
		}
		long[] dp = new long[1001];
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i <= 1000; i++)
			dp[i] = (i * dp[i - 1] + (i / 2) * factorial[i - 1]) % mod;
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println("#" + t + " " + dp[n]);
		}
	}
}