import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA7236 {
    private static int [] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int [] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static char [][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == 'W') {
                        int cnt = 0;
                        for(int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 'W') cnt++;
                        }
                        max = Math.max(max, cnt);
                    }
                     
                }
            }
            if(max == 0) System.out.println("#" + t + " " + 1);
            else System.out.println("#" + t + " " + max);
        }
    }
}