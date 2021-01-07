import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class SWEA4301 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        int n = 0;
        int m = 0;
        boolean [][] visited;
        int cnt = 0;
        for(int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visited = new boolean[n][m];
            cnt = 0;
            for(int i = n - 1; i >= 0; i--) {
                for(int j = m - 1; j >= 0; j--) {
                    if(n - i > 2 && m - j > 2 ) {
                        if(!visited[i+2][j] && !visited[i][j+2]) {visited[i][j] = true; cnt++;}
                    }else if(n - i <= 2 && m - j > 2 ) {
                        if(!visited[i][j+2]) {visited[i][j] = true; cnt++;}
                    }else if( n - i > 2 && m - j <= 2 ) {
                        if(!visited[i+2][j]) {visited[i][j] = true; cnt++;}
                    }else if( n - i <= 2 && m - j <= 2 ) {visited[i][j] = true; cnt++;}
                }
            }
            bw.write("#" + t + " " + cnt + "\n");
        }
        br.close();
        bw.close();
    }
}