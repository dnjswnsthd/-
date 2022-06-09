package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * SWEA 2819. 격자판의 숫자 이어 붙이기
 */
public class SWEA2819 {
	static int [][] map;
	static Set<String> set;
	static String tmp;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			map = new int[4][4];
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					tmp = Integer.toString(map[i][j]);
					word(i, j, tmp);
				}
			}
			System.out.println("#" + t + " " + set.size());
		}
	}
	public static void word(int x, int y, String tmp) {
		if(tmp.length() == 7) {
			set.add(tmp);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
				word(nx, ny, tmp + map[nx][ny]);
			}
		}
	}
}
