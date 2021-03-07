import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ1074 {
    public static int r;
    public static int c;
    public static int [] dy = {0, 0, 1, 1};
    public static int [] dx = {0, 1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sol(0, 0, 0, size);
    }
    public static void sol(int x, int y, int cnt, int size) {
//      범위 체크  
        if(x > c || x+size <= c || y > r || y+size <= r) return;
        if(size == 2) { 
            for(int i=0; i < 4; i++) {
            	int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx == c && ny == r) System.out.println(cnt + i);
            }
            return;
        }  
        int size_tmp = size/2;        
        sol(x, y, cnt, size_tmp);        
        sol(x+size_tmp, y, cnt + (size_tmp * size_tmp), size_tmp);
        sol(x, y + size_tmp, cnt + (size_tmp * size_tmp*2), size_tmp);
        sol(x + size_tmp, y + size_tmp, cnt + (size_tmp * size_tmp*3), size_tmp);
    }
}
