import java.util.PriorityQueue;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� Greedy �� �����ϱ�
public class Pro_Greedy_5 {
	static int [] parent;
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int [n];
        PriorityQueue <Edge> pq = new PriorityQueue <Edge>();
        // ���� �θ� ����
        for(int i = 0; i < n; i++) {
        	parent[i] = i;
        }
        // ��� ���� ������ �켱���� ť ����
        for(int i = 0; i < costs.length; i++) {
        	pq.offer(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        while(!pq.isEmpty()) {
        	Edge edge = pq.poll();
        	// �θ� ������ ���� (����Ŭ ����� ����)
        	if(find(edge.start)== find(edge.end)) continue;
        	else {
        		union(edge.start, edge.end);
        		answer += edge.cost;
        	}
        }
        return answer;
    }
	// find : ������ �θ� ã����
	public static int find(int p) {
		if(parent[p] == p) return p;
		return parent[p] = find(parent[p]);
	}
	// union : ������ �θ� �����Ŵ���ν� ���� ����Ǿ��ٴ� ���� ǥ�� 
	public static void union(int a, int b) {
		int rA = find(a);
		int rB = find(b);
		if(rA != rB) parent[rB] = rA;
	}
	public static void main(String [] args) {
		int a = 4;
		int [][] b = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		System.out.println(solution(a,b));
	}
	public static class Edge implements Comparable<Edge>{
		int start, end, cost;
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}
