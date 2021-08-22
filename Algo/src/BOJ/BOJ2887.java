package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2887 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Planet[] p = new Planet[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i] = new Planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }

        PriorityQueue<Edge> edgePQ = new PriorityQueue<>();
        // x��ǥ�� �������� ����, ���� �߰�
        Comparator<Planet> cp = (o1, o2) -> o1.x < o2.x ? -1 : 1;
        Arrays.sort(p, cp);
        for (int i = 1; i < N; i++) {

            edgePQ.add(new Edge(p[i - 1].idx, p[i].idx, Math.abs(p[i].x - p[i - 1].x)));
        }
        // y��ǥ�� �������� ����, ���� �߰�
        cp = (o1, o2) -> o1.y < o2.y ? -1 : 1;
        Arrays.sort(p, cp);
        for (int i = 1; i < N; i++) {

            edgePQ.add(new Edge(p[i - 1].idx, p[i].idx, Math.abs(p[i].y - p[i - 1].y)));
        }
        // z��ǥ�� �������� ����, ���� �߰�
        cp = (o1, o2) -> o1.z < o2.z ? -1 : 1;
        Arrays.sort(p, cp);
        for (int i = 1; i < N; i++) {
            edgePQ.add(new Edge(p[i - 1].idx, p[i].idx, Math.abs(p[i].z - p[i - 1].z)));
        }
        UnionFind unionFind = new UnionFind(N);
        int nEdge = 0;
        int cost = 0;
        while (nEdge < N && !edgePQ.isEmpty()) {
            Edge edge = edgePQ.poll();
            if (unionFind.find(edge.A) != unionFind.find(edge.B)) {
                unionFind.union(edge.A, edge.B);
                nEdge++;
                cost += edge.cost;
            }
        }
        System.out.println(cost);
    }
    public static class Edge implements Comparable<Edge> {
        int A, B;
        int cost;
        Edge(int A, int B, int cost) {

            this.A = A;
            this.B = B;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost < o.cost ? -1 : 1;
        }
    }
}
class Planet {
    int x, y, z;
    int idx;
    Planet(int x, int y, int z, int idx) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.idx = idx;
    }
}
class UnionFind {
    private int[] root;
    UnionFind(int V) {
        root = new int[V + 1];
        init();
    }
    int find(int a) {
        if (root[a] < 0) {
            return a;
        }
        return root[a] = find(root[a]);
    }
    void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        if (root1 == root2) {
            return;
        }
        if (root[root1] > root[root2]) {
            root1 ^= root2;
            root2 ^= root1;
            root1 ^= root2;
        }
        root[root1] += root[root2];
        root[root2] = root1;
    }
    private void init() {
        for (int i = 0; i < root.length; i++) {
            root[i] = -1;
        }
    }
}
