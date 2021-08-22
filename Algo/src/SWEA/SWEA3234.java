package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA3234 {
    private static int n;
    private static int [] weight;
    private static int res;
    public static void main(String [] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            weight = new int [n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            res = 0;
            perm(0, 0, 0);
            System.out.println("#" + t + " " + res);
        }
    }
    private static void perm(int x, int y, int r) {
        if(x == weight.length) res++;
        else {
            for(int i = x; i < weight.length; i++) {
                swap(x, i);
                perm(x + 1, y + weight[x], r);
                if(r + weight[x] <= y) {
                    perm(x + 1, y, r + weight[x]);
                }
                swap(x, i);
            }
        }
         
    }
    private static void swap(int x, int i) {
        int swap = weight[x];
        weight[x] = weight[i];
        weight[i] = swap;
    }
}