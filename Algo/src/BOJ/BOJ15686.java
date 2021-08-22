package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class BOJ15686 {
 
    static int n,m;
    static int[][] map;
    static int MIN = Integer.MAX_VALUE;
    static List<Node> chickens = new ArrayList<Node>();
    static List<Node> homes = new ArrayList<Node>();
    static Node[] selected;
    static int size;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        selected = new Node[m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 2) {
                    chickens.add(new Node(i, j));
                }
                else if(map[i][j] == 1) {
                    homes.add(new Node(i, j));
                }
            }
        }
        size = chickens.size();
        solve(0,0);
        
        System.out.println(MIN);
    }
    
    static void solve(int idx, int cnt) {
        if(cnt == m) {
            int dist = 0;
            
            for (int j = 0; j < homes.size(); j++) {
                Node h = homes.get(j);
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    Node c = selected[i];
                    min = Math.min(min, getDistance(h.x, h.y, c.x, c.y));
                }
                dist += min;
            }
            
            MIN = Math.min(MIN, dist);
            return ;
        }
        
        for (int i = idx; i < size; i++) {
            selected[cnt] = chickens.get(i);
            solve(i+1, cnt+1);
        }
    }
    
    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2); 
    }
}
 
class Node {
    int x;
    int y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}