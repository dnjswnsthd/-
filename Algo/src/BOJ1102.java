import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BOJ1102 {
	static int N,P,input[][],dp[];
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		input = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[1 << 16];
		Arrays.fill(dp, 1 << 30);
		char visit_arr[] = bf.readLine().toCharArray();
		int visit = 0;
		for (int i = 0; i < N; i++) {
			if (visit_arr[i] == 'Y')
				visit |= (1 << i);
		}
		P = Integer.parseInt(bf.readLine());
		int num = proc(visit);
		System.out.println(!flag ? "-1" : num);
	}
	static int proc(int visit) {
		if (dp[visit] != 1 << 30) return dp[visit];
		if (Integer.bitCount(visit) >= P) {
			flag = true;
			return 0;
		}
		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) != 0) {
				for (int j = 0; j < N; j++) {
					if ((visit & (1 << j)) == 0) {
						dp[visit] = Math.min(dp[visit], proc(visit | 1 << j) + input[i][j]);
					}
				}
			}
		}
		return dp[visit];
	}
}
