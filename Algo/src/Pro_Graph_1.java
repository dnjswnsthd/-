import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// 프로그래머스 코딩테스트 연습 그래프 가장 먼 노드
class Pro_Graph_1 {
	public static int solution(int n, int[][] edge) {
		int answer = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < edge.length; i++) {
			list.add(new ArrayList<Integer>());
		}
		int a, b;
		for (int[] node : edge) {
			a = node[0];
			b = node[1];
			list.get(a).add(b);
			list.get(b).add(a);
		}
		int[] cnt = new int[n + 1];
		boolean[] chk = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		chk[0] = chk[1] = true;
		int now;
		while (!q.isEmpty()) {
			now = q.poll();
			for (int v : list.get(now)) {
				if (!chk[v]) {
					cnt[v] = cnt[now] + 1;
					chk[v] = true;
					q.add(v);
				}
			}
		}
		int max = 0;
		for (int c : cnt) {
			if (max < c) {
				max = c;
				answer = 1;
			} else if (max == c)
				answer++;
		}
		return answer;
	}
	public static void main(String [] args) {
		int a = 6;
		int [][] b = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		System.out.println(solution(a,b));
	}
}