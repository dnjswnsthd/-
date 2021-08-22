package BOJ;

import java.io.*;

class BOJ2718 {
    private static int N;
    private static int T;
    private static int[][] cache;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            solve();
        }
        System.out.print(cache[N+1][0]+ "\n");
    }
    static void solve() throws IOException {
        cache = new int[N+2][5];
        cache[1][0] = 1;
        for(int i=2; i<N+2; i++){
            cache[i][0] = cache[i - 2][0] + cache[i - 1][0] + cache[i - 1][1] + cache[i - 1][4] + cache[i - 1][3];
            cache[i][1] = cache[i - 1][0] + cache[i - 1][4];
            cache[i][2] = cache[i - 1][3];
            cache[i][3] = cache[i - 1][0] + cache[i - 1][2];
            cache[i][4] = cache[i - 1][0] + cache[i - 1][1];
        }
    }
}