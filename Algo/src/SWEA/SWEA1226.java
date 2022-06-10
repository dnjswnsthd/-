package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * SWEA 1226. [S/W 문제해결 기본] 7일차 - 미로1
 * 22.06.10
 * 1 : 벽
 * 2 : 출발점
 * 3 : 도착점
 * 가능 = 1, 불가능 = 0 출력
 * 종료 조건 잘 찾기
 */
public class SWEA1226 {
	static int[][] map;
	static int[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			map = new int[16][16];
			visited = new int[16][16];
			res = 0;
			int sx = 0;
			int sy = 0;
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
					if(map[i][j] == 2) {
						sx = i;
						sy = j;
					}
				}
			}
			dfs(sx, sy);
			System.out.println("#" + t + " " + res);
		}
	}

	public static void dfs(int x, int y) {
		if(res == 1) {
			return;
		}
		
		visited[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx == 0 || ny == 0 || nx == 16 || ny == 16) {
				continue;
			}
			if(map[nx][ny] == 3) {
				res = 1;
				return;
			}
			if(map[nx][ny] == 0 && visited[nx][ny] == 0) {
				dfs(nx, ny);
			}
		}
	}
}
