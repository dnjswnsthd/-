import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class SWEA7465{
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = new int[n + 1];
            int [] arr = new int[n + 1];
            makeSet();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int num_1 = Integer.parseInt(st.nextToken());
                int num_2 = Integer.parseInt(st.nextToken());
                union(num_1, num_2);
            }
            for (int i = 1; i < parent.length; i++) {
                parent[i] = findSet(parent[i]);
            }
            for (int i = 1; i < parent.length; i++) {
                arr[parent[i]] = 1;
            }
            for (int i = 1; i < parent.length; i++) {
                if (arr[i] == 1) {
                    cnt++;
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
    static int findSet(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findSet(parent[x]);
    }
    static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if (x == y) {
            return;
        }
        parent[y] = x;
    }
    static void makeSet() {
        for (int k = 1; k < parent.length; k++) {
            parent[k] = k;
        }
    }
}