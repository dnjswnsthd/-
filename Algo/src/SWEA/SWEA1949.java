package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA1949 {
     
    private static int N, K, maxLength, maxHeight, map[][];
    private static boolean[][] visit;
    private static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            maxLength = maxHeight = 0;
             
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visit = new boolean[N][N];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (maxHeight < map[i][j])
                        maxHeight = map[i][j];
                }
            }
            startPoint();
            sb.append("#" + t + " " + maxLength + "\n");
        }
        System.out.println(sb);
    }
 
    private static void startPoint() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == maxHeight) {
                    visit[i][j] = true;
                    dfs(i, j, maxHeight, 1, 0);
                    visit[i][j] = false;
                }
            }
        }
    }
 
    private static void dfs(int x, int y, int height, int length, int shaveCount) {
        for (int d = 0; d < 4; d++) {
            if (maxLength < length) maxLength = length;
             
            int nx = x + dx[d];
            int ny = y + dy[d];
             
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;
             
            if (height <= map[nx][ny]) { 
                if (shaveCount == 0) {      
                    if (height > map[nx][ny] - K) {  
                        visit[nx][ny] = true;
                        dfs(nx, ny, height - 1, length + 1, shaveCount + 1);
                        visit[nx][ny] = false;
                    }
                }
                 
            } else {
                visit[nx][ny] = true;
                dfs(nx, ny, map[nx][ny], length + 1, shaveCount);
                visit[nx][ny] = false;
            }
        }
    }
}