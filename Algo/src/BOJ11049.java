import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11049 {
    static int N;
    static int[] rows = new int[502];
    static int[] cols = new int[502];
    static int[][] dp = new int[502][502];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            rows[i] = Integer.parseInt(st.nextToken());
            cols[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        System.out.println(Integer.toString(getMinCount(1, N)));
    }
    private static int getMinCount(int start, int end) {
        if (start == end)
            return 0;
        if (dp[start][end] != Integer.MAX_VALUE) {
            return dp[start][end];
        }
        for (int i = start; i < end; i++) {
            int cost = getMinCount(start, i) + getMinCount(i + 1, end) + rows[start] * cols[i] * cols[end];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
        return dp[start][end];
    }
}
