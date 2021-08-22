package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10775 {
	public static int g, p;
    public static int[] parent;
    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        parent = new int[g + 1];
        for (int i = 0; i <= g ; i++) {
            parent[i] = i;
        }
        int cnt = 0;
        for (int i = 0; i < p ; i++) {
            int now = Integer.parseInt(br.readLine());
            
            int p = find(now);
            if(p != 0){
                union(p, p - 1);
                cnt++;
            }
            else
                break;
        }
        System.out.println(cnt);
    }
    public static int find(int now) {
        if(now == parent[now])
            return now;
        return parent[now] = find(parent[now]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[x] = y;  	
        }
    }
}