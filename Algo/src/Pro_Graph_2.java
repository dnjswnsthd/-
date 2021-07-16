// 프로그래머스 코딩테스트 연습 graph 순위
public class Pro_Graph_2 {
	public static int solution(int n, int[][] results) {
		int answer = 0;
		boolean[][] chk = new boolean[n][n];
		for (int i = 0; i < results.length; i++) {
			chk[results[i][0] - 1][results[i][1] - 1] = true;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (chk[j][i] && chk[i][k]) {
						chk[j][k] = true;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			int res = 0;
			for (int j = 0; j < n; j++) {
				if (chk[i][j] || chk[j][i]) {
					res++;
				}
			}
			if (res == n - 1) {
				answer++;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		int a = 5;
		int[][] b = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		System.out.println(solution(a, b));
	}
}
