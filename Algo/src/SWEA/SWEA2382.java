package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA2382 {
    private static int n, m, k, res;
    private static int [][] map;
    private static int [][] dir = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int [] change_dir = {0, 2, 1, 4, 3};
    private static Pair_[] micro;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            res = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            micro = new Pair_[k + 1];
            for(int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                micro[i] = new Pair_(x, y, num, dir, true);
            }
            for(int min = 0; min < m; min++) {
                for(int i = 1; i < micro.length; i++) {
                    Pair_ p = micro[i];
                    if(!p.alive) continue;
                    int nx = p.x + dir[p.dir][0];
                    int ny = p.y + dir[p.dir][1];
                    micro[i] = new Pair_(nx, ny, p.num, p.dir, p.alive);
                }
                for(int i = 1; i < micro.length; i++) {
                    Pair_ p = micro[i];
                    if(!p.alive) continue;
                    if(p.x == 0 || p.y == 0 || p.x == n-1 || p.y == n-1) {
                        micro[i].num /= 2;
                        if(micro[i].num == 0) micro[i].alive = false;
                        micro[i].dir = change_dir[p.dir];
                    }else {
                        int max = p.num, sum = p.num, index = i;
                        for(int j = i + 1; j < micro.length; j++) {
                            if(!micro[j].alive) continue;
                            if(micro[j].x == p.x && micro[j].y == p.y) {
                                if(max > micro[j].num) {
                                    sum += micro[j].num;
                                    micro[j].alive = false;
                                }else {
                                    sum += micro[j].num;
                                    max = micro[j].num;
                                    micro[index].alive = false;
                                    index = j;
                                }
                            }
                        }
                        micro[index].num = sum;
                    }
                }
            }
            for(int i = 1; i < micro.length; i++) {
                if(micro[i].alive) res += micro[i].num;
            }
            System.out.println("#" + t + " " + res);
        }
    }
}
class Pair_{
    int x, y, num, dir;
    boolean alive;
    Pair_(int x, int y, int num, int dir, boolean alive){
        this.x = x; 
        this.y = y;
        this.num = num;
        this.dir = dir;
        this.alive = alive;
    }
}