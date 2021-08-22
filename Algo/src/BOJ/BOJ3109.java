package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109{
	private static int r, c, cnt;
	private static int [][] map;
	private static int [] dir = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			String [] str = br.readLine().split("");
			//int������ Ǯ���ϰ� �;� 0�� 1�� �ٲ�Z��.
			for(int j = 0; j < c; j++) {
				if (str[j].equals(".")) {
					map[i][j] = 0;
				}else {
					map[i][j] = 1;
				}
			}
		}
		cnt = 0;
		//�� ó�� ������ dfs �������ش�.
		for(int i = 0; i < r; i++) dfs(i, 0);
		
		System.out.println(cnt);
	}
	private static boolean dfs(int x, int y) {
		for(int i = 0; i < 3; i++) {
			int nx = x + dir[i];
			int ny = y + 1;
			if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
				continue;
			}
			//���� ���� �����ϰ� �ǹ��� �ƴ� ��Ͽ� ������ ��ġ
			if (map[nx][ny] == 0) {
				//y ���� �� �����ʿ� c-1�� ���������� �湮 üũ �� cnt�� �������ְ� dfs ����
				if (ny == c - 1) {
					map[nx][ny] = 1;
					cnt++;
					return true;
				}
				map[nx][ny] = 1;
				//����ġ�⸦ �����ϱ� ���ؼ� ture�� �����Ѵ�.
				if(dfs(nx, ny)) {
					return true;
				}
			}
		}
		return false;
	}
}