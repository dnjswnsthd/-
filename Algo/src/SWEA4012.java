import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class SWEA4012 {
    private static int n, min;
    private static int[][] map;
    private static boolean[] visited;
    private static ArrayList <Integer> food_a, food_b;
    public static void main(String [] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
             
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            visited = new boolean[n];
            Comb(0, n, n/2);
            System.out.println("#" + t + " " + min);
        }
    }
 
    private static void Comb(int start, int n, int r) {
        if(r == 0) {
            int tmp = sol();
            if(min > tmp) min = tmp;
            return;
        }
        for(int i = start; i < n; i++) {
            visited[i] = true;
            Comb(i + 1, n, r - 1);
            visited[i] = false;
        }
    }
 
    private static int sol() {
        food_a = new ArrayList <Integer> ();
        food_b = new ArrayList <Integer> ();
        //음식 별로 식재료를 나눈다.
        for(int i = 0; i < n; i++) {
            if(visited[i]) food_a.add(i);
            else food_b.add(i);
        }
        //음식별 시너지 합
        int sum_a = 0, sum_b = 0;
        for(int i = 0; i < food_a.size() - 1; i++) {
            for(int j = i; j < food_a.size(); j++) {
                sum_a += map[food_a.get(i)][food_a.get(j)];
                sum_a += map[food_a.get(j)][food_a.get(i)];
                sum_b += map[food_b.get(i)][food_b.get(j)];
                sum_b += map[food_b.get(j)][food_b.get(i)];
            }
        }
        return Math.abs(sum_a - sum_b);
    }
}