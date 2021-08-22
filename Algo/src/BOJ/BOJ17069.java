package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17069 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		long dp[][][] = new long[3][n][n];
		for(int i =0 ;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j < n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0][1] = 1; //0 가로 1 대각선 2 세로
		for(int i =0 ;i < n;i++) {
			for(int j= 0;j<n;j++) {
				
				if(j+1< n && map[i][j+1] == 0 ) {//가로로 한칸이동
					dp[0][i][j+1] += dp[0][i][j];
					dp[0][i][j+1] += dp[1][i][j];
				}
				if(j+1 < n && i+1 < n && map[i+1][j]==0 && map[i+1][j+1]==0 && map[i][j+1] ==0) {
					dp[1][i+1][j+1] += dp[0][i][j];
					dp[1][i+1][j+1] += dp[2][i][j];
					dp[1][i+1][j+1] += dp[1][i][j];
				} //대각선 이동
				
				if(i+1 < n && map[i+1][j]==0) {
					dp[2][i+1][j] += dp[2][i][j];
					dp[2][i+1][j] += dp[1][i][j];
					
				}//세로 이동		
			}
		}
		long answer = 0;
		for(int i =0 ;i <3;i++) {
			answer+=dp[i][n-1][n-1];
		}
		System.out.println(answer);
	}
}