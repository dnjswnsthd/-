import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15961 {
	private static int n, d, k , c;
	private static int cnt, res;
	private static int [] dish;
	private static int [] visited;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visited = new int[d + 1];
		dish = new int[n];
		for(int i = 0; i < n; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(sol());
	}
	private static int sol() {
		for(int i = 0; i < k; i++) {
			if(visited[dish[i]] == 0) cnt++;
			visited[dish[i]]++;
		}
		res = cnt;
		for(int i = 1; i < n; i++) {
			if(res <= cnt) {
				if(visited[c] == 0) res = cnt + 1;
				else res = cnt;
			}
			visited[dish[i - 1]]--;
			if(visited[dish[i-1]] == 0) cnt--;
			if(visited[dish[(i+k-1)%n]] == 0) cnt++;
			visited[dish[(i+k-1)%n]]++;
		}
		return res;
	}
}
