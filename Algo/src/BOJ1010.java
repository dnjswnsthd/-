import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int dp[][] = new int[N+1][M+1];
			for(int n=2;n<=N;n++)
				dp[n][1]=0;
			for(int m=1;m<=M;m++)
				dp[1][m]=m;
			for(int x=2;x<=N;x++) {
				for(int y=2;y<=M;y++) {
					dp[x][y]=dp[x][y-1]+dp[x-1][y-1];
				}
			}
			System.out.println(dp[N][M]);
		}
	}
}