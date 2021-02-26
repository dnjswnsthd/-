import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2468 {
	static int n;
	static int[][] map;
	static boolean[][] visited; 

	static int cnt = 0;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		int max = 0; 
		int min = 100;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if(map[i][j] > max) max = map[i][j];
				if(map[i][j] < min) min = map[i][j];
			}
		}
		
		int result = 1;
		for(int i = min; i < max; i++) {
			cnt = 0;
			for(int j = 0; j < n; j++) {
				Arrays.fill(visited[j], false);
			}
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < n; y++) {
					if(!visited[x][y] && map[x][y] > i) { 
						dfs(x,y,i);
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}

	private static void dfs(int x, int y, int h) { 
		if(x < 0 || x >= n || y < 0 || y >= n) {
			return;
		}
		if(visited[x][y] || map[x][y] <= h) {
			return;
		}	
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			dfs(nx, ny, h);
		}
	}
}