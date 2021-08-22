package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17144 {
	private static int [][] map;
	private static boolean [][] visited;
	private static int [] dx = {-1, 0, 1, 0};
	private static int [] dy = {0, -1, 0, 1};
	private static int r, c, t;
	private static int cnt;
	private static int [] clean_x = new int [2];
	private static int [] clean_y = new int [2];
	private static int res;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					clean_x[cnt] = i;
					clean_y[cnt] = j;
					cnt++;
				}
			}
		}
		sol(0);
		System.out.println(res);
	}
	private static void sol(int time) {
		int [][] map_tmp = new int[r][c];
		int cnt_tmp = 0;
		if(time == t) {
			int total = 0;
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(map[i][j] != -1) total += map[i][j];
				}
			}
			res = total;
			return;
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != 0 && map[i][j] != -1) {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						//map_tmp에 확산된 먼지를 넣는다.
						if(nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != -1) {
							map_tmp[nx][ny] += map[i][j] / 5;
							cnt_tmp++;
						}
					}
					//원래 map에서는 확산이 되었기 떄문에 1/5씩 감소시킨다.
					map[i][j] -= map[i][j] / 5 * cnt_tmp;
					cnt_tmp = 0;
				}
			}
		}
		//확산이 종료되었으면, map에 map_tmp을 더해주고 공기청정기 시작.
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				map[i][j] += map_tmp[i][j];
			}
		}
		for(int i = clean_x[0] - 1; i >= 0; i--) {if(i != 0) map[i][0] = map[i-1][0];}
		for(int i = 0; i < c-1; i++) map[0][i] = map[0][i+1];
		for(int i = 0; i < clean_x[0]; i++) map[i][c-1] = map[i+1][c-1];
		for(int i = c - 1; i >= 1; i--) {
			map[clean_x[0]][i] = map[clean_x[0]][i-1];
			if(i==1) map[clean_x[0]][i] = 0;
		}
		for(int i = clean_x[1] + 1; i < r; i++) {
			if(i != r - 1) map[i][0] = map[i + 1][0];
		}
		for(int i = 0; i < c-1; i++)  map[r-1][i] = map[r-1][i+1];
		for(int i = r - 1; clean_x[1] < i; i--) map[i][c-1] = map[i-1][c-1];
		for(int i = c-1; i >= 1; i--) {
			map[clean_x[1]][i] = map[clean_x[1]][i-1];
			if(i==1) map[clean_x[1]][i] = 0;
		}
		sol(time+1);
	}
}
