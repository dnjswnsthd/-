package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class BOJ1761{
    public static class Node {
        int y;
        int v;
        public Node(int y, int v) {
            this.y = y;
            this.v = v;
        }
    }
    public static int N, M, dp[][], depth[], dist[];
    public static List<List<Node>> list;
    public static boolean vtd[];
    public static int maxlevel = 16;
    public static void dfs(int cur, int parent) {
        vtd[cur] = true;
        depth[cur] = depth[parent] + 1;
        for(Node next: list.get(cur)) {
            if(!vtd[next.y]) {
                vtd[next.y] = true;
                dp[next.y][0] = cur;
                dist[next.y] = dist[cur] + next.v;
                dfs(next.y, cur);
            }
        }
    }
    public static void solve() {
        for(int y = 1; y <= maxlevel; y++) {
            for(int x = 1; x <= N; x++) {
                dp[x][y] = dp[dp[x][y-1]][y-1];
            }
        }
    }
    public static int lca(int x, int y) {
        if(depth[x] < depth[y]) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        for(int i = maxlevel; i >= 0; i--) {
            if(Math.pow(2, i) <= depth[x] - depth[y]) {
                x = dp[x][i];
            }
        }
        if(x == y) return x;
        else {
            for(int i = maxlevel; i >= 0; i--) {
                if(dp[x][i] != dp[y][i]) {
                    x = dp[x][i];
                    y = dp[y][i];
                }
            }
            x = dp[x][0];
        }
        return x;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        vtd = new boolean[N+1];
        dp = new int[N+1][maxlevel+1];
        depth = new int[N+1];
        dist = new int[N+1];
        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(x).add(new Node(y,v));
            list.get(y).add(new Node(x,v));
        }
        dfs(1, 0);
        solve();
        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int res = lca(x, y);
            System.out.println(dist[x] + dist[y] - 2*dist[res]);
        }
    }
}