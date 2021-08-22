package Programmers_level1_2;

import java.util.LinkedList;
import java.util.Queue;
// 프로그래머스 코딩테스트 연습 게임 맵 최단거리
public class Pro_MapMinDi {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean[][] visited;
    static int n, m;
    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[maps.length][maps[0].length];
        return bfs(0, 0, maps);
    }

    private static int bfs(int i, int j, int[][] maps) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j, 1));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x == n - 1 && p.y == m - 1)
                return p.distance;
            for (int k = 0; k < 4; k++) {
                int ni = p.x + dx[k];
                int nj = p.y + dy[k];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && maps[ni][nj] == 1 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.offer(new Pair(ni, nj, p.distance + 1));
                }
            }
        }
        return -1;
    }
    public static class Pair{
        int x;
        int y;
        int distance;

        public Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        System.out.println(solution(maps));
    }
}