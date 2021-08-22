package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA7699 {
    private static int r, c;
    private static int max;
    private static char [][] map;
    private static int [] dx = {-1, 0, 1, 0};
    private static int [] dy = {0, -1, 0, 1};
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new char[r + 1][c + 1];
            max = Integer.MIN_VALUE;
            visited = new boolean[26];
            for (int i = 1; i <= r; i++) {
                String str = br.readLine();
                for (int j = 1; j <= c; j++)
                    map[i][j] = str.charAt(j - 1);
            }
            sol(1, 1, 1);
            System.out.println("#" + t + " " + max);
        }
    }
    private static void sol(int x, int y, int depth) {
        //알파뱃 순서로 배열 방문 체크를 한다.
        if(max == 26) return;
        visited[map[x][y] - 'A'] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx > 0 && nx <= r && ny > 0 &&  ny <= c) {
                //4방위 탐색으로 방문되지 않았을 경우 재귀
                if(!visited[map[nx][ny] - 'A']) {
                    sol(nx, ny, depth + 1);
                }
            }
        }
        visited[map[x][y] - 'A'] = false;
        max = Math.max(max, depth);
        if(max == 26){return;}
    }
}