import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ11967 {
	static int n, m;
    static int[] dr = { -1, 0, 1, 0 }, dc = { 0, -1, 0, 1 };
    static ArrayList<Pair>[][] sw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sw = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	sw[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sw[x][y].add(new Pair(a, b));
        }
 
        System.out.println(process());
    }
 
    private static int process() {
        boolean[][] visited = new boolean[n][n];
        boolean[][] chk = new boolean[n][n];
        int cnt = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        chk[0][0] = true;
        visited[0][0] = true;
        while (!queue.isEmpty()) {
        	Pair now = queue.poll();
            if(sw[now.r][now.c].size() > 0) {
                boolean flag = false;
                for (Pair p : sw[now.r][now.c]) {
                    if(!chk[p.r][p.c]) {
                    	chk[p.r][p.c] = true;
                        flag = true;
                        cnt++;
                    }
                }
                if(flag) {
                	queue.clear();
                	queue.add(new Pair(0, 0));
                    visited = new boolean[n][n];
                    visited[0][0] = true;
                    continue;
                }
            }
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if(visited[nr][nc] || !chk[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new Pair(nr, nc));
            }
        }
        return cnt;
    }
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
