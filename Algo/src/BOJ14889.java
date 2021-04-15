import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
	private static int n;
	private static int [][] map;
	static boolean [] team;
	static int min = Integer.MAX_VALUE;
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		team = new boolean[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sol(0, 0);
		System.out.println(min);
	}
	private static void sol(int cnt, int cur) {
		if(cnt == n / 2) {
			int sum_a = 0, sum_b = 0;
			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					if(team[i] != team[j]) continue;
					if(team[i]) sum_a += map[i][j] + map[j][i];
					else sum_b += map[i][j] + map[j][i];
				}
			}
			min = Math.min(min, Math.abs(sum_a - sum_b));
			return;
		}
		for(int i = cur; i < n; i++) {
			team[i] = true;
			sol(cnt + 1, i + 1);
			team[i] = false;
		}
	}
}
