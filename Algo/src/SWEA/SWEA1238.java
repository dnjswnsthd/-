package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA 1238. [S/W 문제해결 기본] 10일차 - Contact
 * 22.06.14
 */
public class SWEA1238 {
	static int[][] graph;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			graph = new int[n][n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = 1;
			}
			System.out.println("#" + t + " " + bfs(start));
		}
	}
	public static int bfs(int start) {
		int [] visited = new int[graph.length];
		int max = 0, res = 0;
		Queue <Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = 1;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i = 1; i < graph.length; i++) {
				if(graph[tmp][i] != 1 || visited[i] != 0) continue;
				visited[i] = visited[tmp] + 1;
				q.offer(i);
			}
			max = visited[tmp];
		}
		for(int i = 1; i < graph.length; i++) {
			if(max != visited[i]) continue;
			res = res > i ? res : i;
		}
		return res;
	}
}
