import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2458 {
	private static int n, m, tc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boolean[][] student = new boolean[n + 1][n + 1];
		boolean[][] r_student = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			student[a][b] = true;
			r_student[b][a] = true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (student[i][k] && student[j][i])
						student[j][k] = true;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (r_student[i][k] && r_student[j][i])
						r_student[j][k] = true;
				}
			}
		}
		// |을 취한 값이 false라면, 그 학생과 키 비교를 할 수 없다는 의미.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				student[i][j] |= r_student[i][j];
			}
		}
		int res = 0;
		loop: for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
	     		// 자기 자신 제외
				if (i == j)
					continue;
				// 키 비교를 할 수 없는 학생이 존재한다면 continue.
				if (!student[i][j])
					continue loop;
			}
			res++;
		}
		System.out.println(res);
	}
	
}