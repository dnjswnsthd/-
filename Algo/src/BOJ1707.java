import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1707 {
	static int v, e;
	static ArrayList <Integer> [] list = (ArrayList <Integer> []) new ArrayList[20001];
	static int [] visited = new int [200001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= v; i++) {
				list[i] = new ArrayList <Integer> ();
				visited[i] = 0;
			}
			for(int i = 0; i < e; i++) {
				int from, to;
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			for(int i = 1; i <= v; i++) {
				if(visited[i] == 0) dfs(i, 1);
			}
			boolean chk = false;
			for(int i = 1; i <=v; i++) {
				for(int j = 0; j < list[i].size(); j++) {
					int k = list[i].get(j);
					if(visited[i] == visited[k]) chk = true;
				}
			}
			if(!chk) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
	private static void dfs(int x, int y) {
		visited[x] = y;
		for(int i = 0; i < list[x].size(); i++) {
			int tmp = list[x].get(i);
			if(visited[tmp] == 0) dfs(tmp, 3-y);
		}
	}
}