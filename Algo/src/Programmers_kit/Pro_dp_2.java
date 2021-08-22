package Programmers_kit;

// 프로그래머스 코딩테스트 연습 dp 정수 삼각형

public class Pro_dp_2 {
	public static int solution(int[][] triangle) {
		int[][] dp = new int[triangle.length][triangle.length];
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			dp[i][0] = triangle[i][0] + dp[i - 1][0];
			for (int j = 1; j < i + 1; j++) {
				dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp[dp.length - 1].length; i++) {
			max = Math.max(dp[dp.length - 1][i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] a = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(solution(a));
	}
}
