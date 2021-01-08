import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA7733 {
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = { -1, 1, 0 ,0 };
    private static int[] dy = { 0, 0 , -1, 1 };
    private static int tmp;
    private static int total;
    private static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());    
        for (int t = 1; t <= tc; t++) {
            int max = 1;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            total = n * n;
            int day = 0;
            while (total != 0) {
                day++;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == day) {
                            map[i][j] = 0;
                            total--;
                        }
                    }
                }
                if (total == 0)
                    break;
                visited = new int[n][n];
                tmp = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] > 0 && visited[i][j] == 0) {
                            dfs(i, j);
                            tmp++;
                        }
                    }
                }
                if (tmp > max) {
                    max = tmp;
                }
            }
            System.out.println("#" + t + " " + max);
        }
    }
    private static void dfs(int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] > 0 && visited[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
 
    }
 
}