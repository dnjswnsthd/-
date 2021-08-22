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
			//int형으로 풀이하고 싶어 0과 1로 바꿔줫다.
			for(int j = 0; j < c; j++) {
				if (str[j].equals(".")) {
					map[i][j] = 0;
				}else {
					map[i][j] = 1;
				}
			}
		}
		cnt = 0;
		//맨 처음 열부터 dfs 수행해준다.
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
			//범위 내에 존재하고 건물이 아닌 블록에 수도관 설치
			if (map[nx][ny] == 0) {
				//y 값이 맨 오른쪽에 c-1과 동일해지면 방문 체크 및 cnt를 증가해주고 dfs 종료
				if (ny == c - 1) {
					map[nx][ny] = 1;
					cnt++;
					return true;
				}
				map[nx][ny] = 1;
				//가지치기를 방지하기 위해서 ture를 리턴한다.
				if(dfs(nx, ny)) {
					return true;
				}
			}
		}
		return false;
	}
}