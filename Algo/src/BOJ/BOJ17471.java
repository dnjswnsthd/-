package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ17471 {
	private static int n, res = Integer.MAX_VALUE;
	private static int [] people;
	private static boolean [] vote;
	private static boolean [][] connected;
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		vote = new boolean[n + 1];
		connected = new boolean[n + 1][n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < n + 1; i++){
			st = new StringTokenizer(br.readLine());
			connected[i][i] = true;
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				connected[i][tmp] = true;
				connected[tmp][i] = true;
			}
		}
		setVote(1);
		if(res == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
	}
	private static void setVote(int start) {
		if(start == n + 1) {
			if (check(true) && check(false)) {
				res = Math.min(res, sol());
			}
			return;
		}
		vote[start] = true;
		setVote(start + 1);
		vote[start] = false;
		setVote(start + 1);
	}
	private static int sol() {
		int first = 0, second = 0;
		for(int i = 1; i < n + 1; i++) {
			if(vote[i]) first += people[i];
			else second += people[i];
		}
		return Math.abs(first - second);
	}
	private static boolean check(boolean b) {
		boolean [] visited = new boolean[n + 1];
		LinkedList <Integer> dist = new LinkedList <Integer>();
		for(int i = 1; i < n + 1; i++) {
			if(vote[i] == b) {
				dist.add(i);
				visited[i] = true;
				break;
			}
		}
		while (!dist.isEmpty()) {
			int cur = dist.poll();
			for(int i = 1; i < n + 1; i++) {
				if(visited[i]) continue;
				if(b != vote[i]) continue;
				if(connected[cur][i] == false) continue;
				dist.add(i);
				visited[i] = true;
			}
		}
		for(int i = 1; i < n + 1; i++) {
			if(vote[i] != b) continue;
			if(!visited[i]) return false;
		}
		return true;
	}
}