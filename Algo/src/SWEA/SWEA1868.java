package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
  
public class SWEA1868 {
    private static int tc, n, res, mine, click, clickCnt;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = new int[] { 0, 0, -1, -1, -1, 1, 1, 1 };
    private static int[] dy = new int[] { -1, 1, -1, 0, 1, -1, 0, 1 };
    private static Queue<Pair> que = new LinkedList<Pair>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            visited = new boolean[n][n];
            res = click = mine = clickCnt = 0;
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '*')
                        mine += 1;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
  
                    if (map[i][j] != '*' && isPossible(i, j) && !visited[i][j]) {
                        sol(i, j);
                    }
                }
            }
            clickCnt = cntClick();
            System.out.println("#" + t + " " + (click + clickCnt));
        }
    }
    public static int cntClick() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != '*')
                    cnt += 1;
            }
        }
        return cnt;
    }
    public static boolean isPossible(int row, int col) {
        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (!(nx >= 0 && nx < n && ny >= 0 && ny < n))
                continue;
            if (map[nx][ny] != '.')
                return false;
        }
        return true;
    }
    public static void sol(int x, int y) {
        que.clear();
        que.offer(new Pair(x, y));
        click += 1;
        while (!que.isEmpty()) {
            Pair node = que.poll();
            visited[node.x][node.y] = true;
            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (isPossible(nx, ny))
                        que.offer(new Pair(nx, ny));
                }
            }
        }
    }
    public static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}