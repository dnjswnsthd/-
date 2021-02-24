import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ1697 {
	static int n, k;
	static int [] visited = new int[100001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(visited[k]-1);
	}
	private static void bfs() {
		Queue <Integer> que = new LinkedList<Integer>();
		que.offer(n);
		visited[n] = 1;
		while(!que.isEmpty()) {
			n = que.poll();
			if(n == k) break;
			if(n+1 <= 100000 && visited[n+1] == 0) {
				que.offer(n+1);
				visited[n+1] = visited[n] + 1;
			}
			if(n-1 >= 0 && visited[n-1] == 0) {
				que.offer(n-1);
				visited[n-1] = visited[n] + 1;
			}
			if(n*2 <= 100000 && visited[n*2] == 0) {
				que.offer(n*2);
				visited[n*2] = visited[n] +1;
			}
		}
	}
}