import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ1600 {
    static int K,W,H;
    static int arr[][];
    static int moveX[] = {0,1,0,-1};
    static int moveY[] = {-1,0,1,0};
    static int X_move[] = {1,2,2,1,-1,-2,-2,-1};
    static int Y_move[] = {-2,-1,1,2,2,1,-1,-2};
    static boolean visit[][][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        arr = new int[H+1][W+1];
        visit = new boolean[H+1][W+1][K+1];
        for(int i=1; i<=H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }
    private static int bfs() {
        Queue <Po> queue = new LinkedList<>();
        queue.add(new Po(1,1,0,0));
        visit[1][1][0] = true;
        
        while(!queue.isEmpty()) {
            Po p = queue.poll();
            // 최단값 리턴 
            if(p.y == H && p.x == W)
                return p.cnt;
            // 원숭이가 말처럼 움직일 수 있는 횟수가 남아있는 경우
            if(p.k < K) {
                for(int d=0; d<8; d++) {
                    int newX = p.x + X_move[d];
                    int newY = p.y + Y_move[d];
                    if(1<=newY && newY<=H && 1<=newX && newX<=W) {
                        if(!visit[newY][newX][p.k+1] && arr[newY][newX] == 0) {
                            visit[newY][newX][p.k+1] = true;
                            queue.add(new Po(newX, newY, p.k+1, p.cnt+1));
                        }
                    }
                }
            }
            // 원숭이가 말처럼 움직일 수 없는 경우 
            for(int d=0; d<4; d++) {
                int newX = p.x + moveX[d];
                int newY = p.y + moveY[d];
                if(1<=newY && newY<=H && 1<=newX && newX<=W) {
                    if(!visit[newY][newX][p.k] && arr[newY][newX] == 0) {
                        visit[newY][newX][p.k] = true;
                        queue.add(new Po(newX, newY, p.k, p.cnt+1));
                    }
                }
            }
        }   
        return -1;
    }
}
class Po{
    int x;
    int y;
    int k;
    int cnt;
    public Po(int x, int y, int k, int cnt) {
        this.x=x;
        this.y=y;
        this.k=k;
        this.cnt=cnt;
    }
}