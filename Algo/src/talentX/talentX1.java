package talentX;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class talentX1 {
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int area;
    public static int countGroups(List<String> related) {
        int m = related.size();
        int n = related.get(0).length();
        int[][] map = new int[m][n];
        for (int i = 0; i < related.size(); i++) {
            String tmp = related.get(i);
            for (int j = 0; j < related.get(i).length(); j++) {
                map[i][j] = Integer.parseInt(Character.toString(tmp.charAt(j)));
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            area = 0;
            if (map[i][i] == 1) {
                cnt++;
                dfs(i, i, map);
                pq.offer(area);
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y, int[][] map) {
        map[x][y] = 2;
        area++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length) {
                if (map[nx][ny] == 1) {
                    dfs(nx, ny, map);
                }
            }
        }

    }

    public static void main(String[] args) {
        int size = 4;
        ArrayList<String> related = new ArrayList<>();
        related.add("1100");
        related.add("1110");
        related.add("0110");
        related.add("0001");
        System.out.println(countGroups(related));
    }
}
