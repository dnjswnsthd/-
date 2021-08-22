package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15685 {
	static int[][] map = new int[101][101];
	static int cnt = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragon(x, y, d, g);
		}
		chkSq();
		System.out.println(cnt);
	}
	//각 줄의 입력에 따라 map의 드래곤 이동을 찍는다.
	public static void dragon(int x, int y, int d, int g) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int tmp_d = d;
		arr.add(tmp_d);
		for (int i = 1; i <= g; i++) {
			for (int j = arr.size() - 1; j >= 0; j--) {
				// 나눠서 0,1,2,3의 값만 나올 수 있게 한다.
				tmp_d = (arr.get(j) + 1) % 4;
				arr.add(tmp_d);
			}
		}
		int tmp_x = x;
		int tmp_y = y;
		for (int i = 0; i < arr.size(); i++) {
			map[tmp_y][tmp_x] = 1;
			tmp_x += dx[arr.get(i)];
			tmp_y += dy[arr.get(i)];
		}
		// 마지막에 넣어주지 않기 때문
		map[tmp_y][tmp_x] = 1;
	}
	// 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수를 구하는 메소드
	public static void chkSq() {
		int[] dx = {1, 0, 1};
		int[] dy = {0, 1, 1};
		int chk_cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 3; k++) {
						int tmp_i = i + dy[k];
						int tmp_j = j + dx[k];
						// 범위를 넘어가지 않고 드래곤 커브의 일부일때
						if (tmp_i >= 0 && tmp_i < 101 && tmp_j >= 0 && tmp_j < 101 && map[tmp_i][tmp_j] == 1) {
							chk_cnt++;
						}
					}
					// chk_cnt가 3이 되면 해당되는 경우
					if (chk_cnt == 3) {
						cnt++;
					}
					chk_cnt = 0;
				}
			}
		}
	}
}