package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA1211.[S/W 문제해결 기본] 2일차 - Ladder2
 * 22.06.02
 */
public class SWEA1211 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			int[][] ladder = new int[100][100];
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				if (ladder[0][i] == 1) {
					int[][] visited = new int[100][100];
					int r = 0, c = i;
					int distance = 0;
					while (r < 99) {
						visited[r][c] = 1;
						if (c - 1 >= 0 && visited[r][c - 1] == 0 && ladder[r][c - 1] == 1) {
							c--;
						} else if (c + 1 < 100 && visited[r][c + 1] == 0 && ladder[r][c + 1] == 1) {
							c++;
						} else if (r + 1 < 100 && visited[r + 1][c] == 0 && ladder[r + 1][c] > 0) {
							r++;
						}
						distance++;
					}
					if(distance < min) {
						min = distance;
						idx = i;
					}
				}
			}
			System.out.println("#" + t + " " + idx);
		}
	}
}
