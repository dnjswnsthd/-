import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ2248 {
	static int N, L;
	static long I;
	static String res;
	static long[][] dp = new long[50][50];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		I = Long.parseLong(st.nextToken());
		for(int i=0; i<= N; i ++)
		{
			dp[i][0] = 1;
			dp[0][i] = 1;
		}
		res = "";
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= L; j++)
			{
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		sol(N,L,I,0);
		System.out.println(res);
	}
	public static void sol(int n, int m, long k, int p){
		if(n ==0) return;
		if(m == 0)
		{
			for(int i=0; i< n; i++) res += '0';
			return;
		}
		long target = dp[n-1][m];
		if(target < k) {
			res += '1';
			sol(n-1, m-1, k-target, p+1);
		}
		else {
			res += '0';
			sol(n-1, m, k, p+1);
		}
	}
}