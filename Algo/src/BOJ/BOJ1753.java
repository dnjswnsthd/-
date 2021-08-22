package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
	private static int v, e, k;
	private static ArrayList <Edge> [] map;
	private static int [] dist;
	private static PriorityQueue <Edge> pq = new PriorityQueue <> (new Comparator <Edge>() {
		public int compare(Edge e_fi, Edge e_se) {
			return e_fi.value - e_se.value;
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		k = Integer.parseInt(br.readLine());
		map = new ArrayList[v + 1];
		dist = new int [v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;
		pq.add(new Edge(k, 0));
		for(int i = 1; i <= v; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		sol();
		for(int i = 1; i <= v; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
	private static void sol() {
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for(Edge next : map[cur.dest]) {
				if(dist[next.dest] > dist[cur.dest] + next.value) {
					dist[next.dest] = dist[cur.dest] + next.value;
					pq.add(new Edge(next.dest, dist[next.dest]));
				}
			}
		}
		
	}
}
class Edge{
	int dest;
	int value;

	Edge(int dest, int value){
		this.dest = dest;
		this.value = value;
	}
}