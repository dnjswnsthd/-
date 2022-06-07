package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 1219. [S/W 문제해결 기본] 4일차 - 길찾기
 * 22.06.07 
 */
public class SWEA1219 {
	static int [][] road;
	static int [] visited;
	static int res;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			road = new int [100][100];
			visited = new int [100];
			res = 0;
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				road[x][y] = 1;
			}
			dfs(0);
			System.out.println("#" + t + " " + res);
		}
	}
	public static void dfs(int x) {
		if(res == 1) return;
		if(x == 99) {
			res = 1;
			return;
		}
		visited[x] = 1;
		for(int i = 0; i < 100; i++) {
			if(visited[i] == 0 && road[x][i] == 1) {
				dfs(i);
			}
		}
		//visited[x] = 0;
	}
}
