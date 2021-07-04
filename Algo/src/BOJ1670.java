import java.io.*;
class BOJ1670 {
    static int stoi(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        long[] dp = new long[100001];
        final long div = 987654321;
        dp[0] = 1;
        dp[2] = 1;
        for(int i=4; i<=n; i += 2) {
            for(int j=0; j<=i-2; j += 2) {
                dp[i] += dp[j] * dp[i-j-2];
                dp[i] %= div;
            }
        }
        System.out.println(dp[n]);
    }
}