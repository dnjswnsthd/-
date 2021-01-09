import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA2001 {
    static int [][] map;
    static int [][] mos;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            mos = new int[m][m];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for(int i = 0; i <= n-m; i++) {
                for(int j = 0; j <= n-m; j++) {
                    int cnt = 0;
                    for(int k = i; k < i+m; k++) {
                        for(int l = j; l < j+m; l++) {
                            cnt += map[k][l];
                            if(max < cnt) max = cnt;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + max);
        }
    }
}