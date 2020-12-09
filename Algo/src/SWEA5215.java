import java.util.Scanner;
 
public class SWEA5215 {
    static int n, l, maxTaste;
    static int[] taste, kcal;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
  
        for(int tc=1; tc<=T; tc++) {
            n = sc.nextInt();
            l = sc.nextInt();
            maxTaste = 0;
            taste = new int[n];
            kcal = new int[n];
            for(int i=0; i<n; i++) {
                taste[i] = sc.nextInt();
                kcal[i] = sc.nextInt();
            }
            dfs(0, 0, 0);
            System.out.format("#%d %d\n", tc, maxTaste);
        }
        sc.close();
    }
     
    public static void dfs(int t, int c, int k) {
        if(k+1 > n) {
            if( c <= l && t > maxTaste ) maxTaste = t;
            return;
        }
        dfs(t, c, k+1);
        dfs(t+taste[k], c+kcal[k], k+1);
    }
}