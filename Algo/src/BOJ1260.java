import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1260 {
	static int [][] map;
	static boolean [] visited;
	static int n, m, v;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] nmv = br.readLine().split(" ");
		n = Integer.parseInt(nmv[0]);
		m = Integer.parseInt(nmv[1]);
		v = Integer.parseInt(nmv[2]);
		
		map = new int [n+1][n+1];
		visited = new boolean [n+1];
		
		for(int i = 0; i < m; i++) {
			String [] xy = br.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			map[x][y] = 1;
			map[y][x] = 1;
		}
		dfs(v);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(v);
	}
	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		for(int i = 0; i < n + 1; i++) {
			if(map[v][i] == 1 && visited[i] == false) dfs(i);
		}
	}
	private static void bfs(int v) {
		Queue <Integer> que = new LinkedList<Integer>();
		visited[v] = true;
		que.offer(v);
		while(!que.isEmpty()) {
			int tmp = que.poll();
			System.out.print(tmp + " ");
			for(int i = 1; i <= n; i++) {
				if(map[tmp][i] == 1 && visited[i] == false) {
					que.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}