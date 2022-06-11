package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA 1861. 정사각형 방
 * 22.06.11
 */
public class SWEA1861new {
	static int roomNumber;
	static int roomMove;
	static int[][] roomMap;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			roomNumber = Integer.MAX_VALUE;
			roomMove = 0;
			int n = Integer.parseInt(br.readLine());
			roomMap = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					roomMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tmp = checkRoom(new Dir(i, j), 1);
					if (tmp > roomMove) {
						roomMove = tmp;
						roomNumber = roomMap[i][j];
					}else if(tmp == roomMove) {
						roomNumber = Math.min(roomNumber, roomMap[i][j]);
					}
				}
			}
			sb.append("#" + t + " " + roomNumber + " " + roomMove + "\n");
		}
		System.out.print(sb);
	}

	public static int checkRoom(Dir dir, int tmp) {
		Queue <Dir> que = new LinkedList<>();
		que.add(dir);
		while(!que.isEmpty()) {
			Dir d = que.poll();
			for(int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if(nx == -1 || ny == -1 || nx == roomMap.length || ny == roomMap.length) {
					continue;
				}
				if(roomMap[nx][ny] == roomMap[d.x][d.y] + 1) {
					que.add(new Dir(nx, ny));
					tmp++;
				}
			}
		}
		return tmp;
	}

	public static class Dir {
		int x;
		int y;

		Dir(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}