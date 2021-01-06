import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class SWEA3124 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int[] p;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int v, e;
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            p = new int[v+1];
            makeSet();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from, to, weight;
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                pq.add(new Node(from, to, weight));
            }
            int size = pq.size();
            int edge = 0;
            long sum = 0;
            for(int i=0; i<size; i++) {
                if(edge == v-1) break;
                Node temp = pq.poll();
                int from, to;
                from = temp.from;
                to = temp.to;
                if(findSet(from)!=findSet(to)) {
                    unionSet(from, to);
                    sum += temp.weight;
                    edge++;
                }
            }
            bw.write("#"+t+" "+sum+"\n");
        }
        br.close();
        bw.close();
    }
 
    private static void unionSet(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if(x == y) return;
        p[y] = x;
    }
    private static int findSet(int x) {
        if(x==p[x]) return x;
         
        int idx = findSet(p[x]);
        p[x] = idx;
        return idx;
    }
 
    private static void makeSet() {
        for(int i=0; i<p.length; i++) {
            p[i] = i;
        }
         
    }
 
    static class Node implements Comparable<Node> {
 
        int from;
        int to;
        int weight;
 
        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Node o) {
 
            return weight>o.weight ?1 : -1;
        }
    }
 
}