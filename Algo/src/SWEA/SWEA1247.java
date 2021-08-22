package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA1247 {
    private static int n;
    private static Loca home;
    private static Loca company;
    private static Loca [] map;
    private static boolean [] visited;
    private static int min;
    private static int tc;
    public static void main(String [] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            map = new Loca[n];
            home = new Loca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            company = new Loca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int i = 0; i < n; i++) {
                map[i] = new Loca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            min = Integer.MAX_VALUE;
            visited = new boolean [n];
            perm(n, company, visited, 0);
            System.out.println("#" + t + " " + min);
        }
    }
    private static void perm(int cho, Loca c, boolean[] v, int cost) {
        if (cost > min) return;
        if(cho == 0) {
            int to = c.cost(home);
            if(cost + to < min) {
                min = cost + to;
            }return;
        }
        for(int i = 0; i < map.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm(cho -1, map[i], visited, cost + c.cost(map[i]));
                visited[i] = false;
            }
        }
    }
}
class Loca{
    int x, y;
    public Loca(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int cost(Loca lo) {
        return Math.abs(this.x - lo.x) + Math.abs(this.y - lo.y); 
    }
}