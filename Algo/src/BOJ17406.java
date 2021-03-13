import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
	private static int n, m, k;
	private static int[][] map;
	private static int[][] map_cp;
	private static int[][] rota;
	private static int[] perm;
	private static int min = Integer.MAX_VALUE;
	private static int[][] dir = { {1,0}, {0,1}, {-1,0}, {0,-1} };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		map_cp = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map_cp[i][j] = map[i][j];
			}
		}
		rota = new int[k][3];
		perm = new int[k];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			rota[i][0] = Integer.parseInt(st.nextToken()) - 1;
			rota[i][1] = Integer.parseInt(st.nextToken()) - 1;
			rota[i][2] = Integer.parseInt(st.nextToken());
		}
		sol(0, 0);
		System.out.println(min);
	}
	private static void sol(int cnt, int chk) {
		if (cnt == k) {
			//rota의 순서인 perm을 기준으로, rotate실행 후 행렬 값을 갱신한다.
			//map_cp 갱신
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map_cp[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < k; i++) {
				rotate(rota[perm[i]][0], rota[perm[i]][1], rota[perm[i]][2]);
			}
			min = Math.min(min, min_tmp());
			return;
		}
		for(int i = 0; i < k; i++) {
			//안썻을 경우
			if((chk & 1 << i) == 0){
				perm[cnt] = i;
				sol(cnt+1, chk | 1 << i);
			}
		}
	}
	private static int min_tmp() {
		int min = Integer.MAX_VALUE;
		int tmp;
		for(int i = 0; i < n; i++) {
			tmp = 0;
			for(int j = 0; j < m; j++) {
				tmp += map_cp[i][j];
			}
			min = Math.min(min, tmp);
		}
		return min;
	}
	private static void rotate(int r, int c, int s) {
		int nx, ny;
		//회전 사각형의 크기
		for(int i = 1; i <= s; i++) {
			nx = r - i;
			ny = c - i;
			//회전 
			for(int d = 0; d < 4; d++) {
				for (int j = 0; j < i * 2; j++) {
					swap(nx, ny, d);
					nx += dir[d][0];
					ny += dir[d][1];
				}
			}
			//마지막 swap은 제외하기 위해서 swap을 한번 더 해준다.
			swap(nx, ny, 1);
		}
	}
	private static void swap(int r, int c, int d) {
		int tmp = 0;
		int nx = r + dir[d][0];
		int ny = c + dir[d][1];
		tmp = map_cp[r][c];
		map_cp[r][c] = map_cp[nx][ny];
		map_cp[nx][ny] = tmp;
	}
}