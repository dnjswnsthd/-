import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class SWEA1861 {
     
    static int N, len;
    static int[][] map, dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] visited;
    static Queue<Pair> que;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            int max = Integer.MIN_VALUE;
            int min_no = Integer.MAX_VALUE;
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    len = 0;
                    visited = new boolean[N][N];
                    BFS(i, j);
                     
                    if(max < len) {
                        max = len;
                        min_no = map[i][j];
                    }
                    if(max == len && min_no > map[i][j]) {
                        min_no = map[i][j];
                    }
                }
            }
            System.out.println("#" + tc + " " + min_no + " " + max);
        }
        sc.close();
    }
     
    public static void BFS(int x, int y) {
        que = new LinkedList<>();
        visited[x][y] = true;
         
        que.offer(new Pair(x, y));
         
        while(!que.isEmpty()) {
            len++;
            int size = que.size();
             
            for(int i=0; i<size; i++) {
                Pair p = que.poll();
                 
                for(int j=0; j<4; j++) {
                    int nx = p.x + dir[j][0];
                    int ny = p.y + dir[j][1];
                     
                    if(isInside(nx, ny) && !visited[nx][ny] && map[nx][ny] == map[p.x][p.y]+1) {
                        que.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
             
        }
         
    }
    public static boolean isInside(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}
class Pair {
    int x;
    int y;
 
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}