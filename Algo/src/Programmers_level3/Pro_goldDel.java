/*
* 코딩테스트 연습 > 월간 코드 챌린지 시즌3 > 금과 은 운반하기
* 22.03.22
 */

public class Pro_goldDel {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long max = (long) (1e9 * 2 * 1e5 * 2);
        long l = 0, r = max, ta, ans = max;
        int n = s.length, i;
        long gm, sm, gsm, gc, sc, wc, tc, rc, wt, ab = a + b, gsc;
        while (l <= r) {
            ta = (l + r) / 2;
            gm = sm = gsm = 0;
            for (i = 0; i < n; i++) {
                gc = g[i];
                sc = s[i];
                wc = w[i];
                tc = t[i];
                gsc = gc + sc;
                rc = (long) Math.ceil((double) (ta / tc) / 2);
                wt = rc * wc;
                gm += Math.min(gc, wt);
                sm += Math.min(sc, wt);
                gsm += Math.min(gsc, wt);
            }
            if (a <= gm && b <= sm && ab <= gsm) {
                r = ta - 1;
                ans = ta;
            } else {
                l = ta + 1;
            }
        }
        return ans;
    }
}