package Programmers_kit;

// 프로그래머스 코딩테스트 연습 dp 등굣길

public class Pro_dp_3 {
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int [][] dp = new int[n + 1][m + 1];
		dp[1][1] = 1;
		for(int i = 0; i < puddles.length; i++) {
			dp[puddles[i][1]][puddles[i][0]] = -1;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(dp[i][j] == -1) {
					continue;
				}
				if(dp[i][j-1] >= 0 && dp[i][j] >= 0) {
					dp[i][j] += dp[i][j-1] % 1000000007;
				}
				if(dp[i-1][j] >= 0 && dp[i][j] >= 0){
					dp[i][j] += dp[i-1][j] % 1000000007;
				}
			}
		}
		answer = dp[n][m] % 1000000007;
		
		return answer;
	}
	public static void main(String[] args) {
		int a = 4;
		int b = 2;
		int[][] c = {{2,2}};
		System.out.println(solution(a, b, c));
	}
}
