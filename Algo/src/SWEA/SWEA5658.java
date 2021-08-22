package SWEA;

import java.util.*;
  
public class SWEA5658 {
    static int T, N, ANS, K, NS;
    static String[] A;
    static HashSet<Integer> hs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            A = new String[N];
            ANS = 0;
            NS = N/4;
            hs = new HashSet<>();
            String str = sc.next();
            for (int i = 0; i <N ; i++) {
                A[i] = String.valueOf(str.charAt(i));
            }
            for (int i = 0; i <NS ; i++) {
                slideRight(i);
                solve();
            }
            List<Integer> ls = new LinkedList<>(hs);
  
            Collections.sort(ls);
            Collections.reverse(ls);
  
            System.out.println("#"+tc+ " " + ls.get(K-1));
        }
    }
    static void solve(){
        String[] ts = new String[NS];
        int i = 0;
        for (int k = 0; k <N ; k++) {
  
            ts[i++] = A[k];
            if(i == NS) {
                hs.add(HtD(ts));
                i = 0;
            }
        }
    }
  
    static int HtD(String[] s){
        int ans = 0;
        int c = NS-1;
        for (int i = 0; i <NS ; i++) {
            int n=0;
            if(s[i].equals("A")) n = 10;
            else if(s[i].equals("B")) n = 11;
            else if(s[i].equals("C")) n = 12;
            else if(s[i].equals("D")) n = 13;
            else if(s[i].equals("E")) n = 14;
            else if(s[i].equals("F")) n = 15;
            else n = Integer.parseInt(s[i]);
            ans += n * Math.pow(16, c);
            c--;
        }
        return ans;
    }
  
    static void slideRight(int c){
        if(c == 0) return;
        String[] ta = new String[N];
        for (int i = 0; i <N ; i++) {
            ta[i] = A[i];
        }
        A[0] = ta[N-1];
        for (int i = 1; i <N ; i++) {
            A[i] = ta[i-1];
        }
    }
}