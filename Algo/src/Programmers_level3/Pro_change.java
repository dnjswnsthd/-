import java.util.*;
/*
* 프로그래머스 > 거스름돈
* 22.04.06
 */
class Pro_change {
    public static final int INF = -1;

    public int solution(int n, int[] money) {
        int answer = 0;
        Arrays.sort(money);
        long[] d = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % money[0] == 0)
                d[i] = 1;
        }
        for (int i = 1; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                d[j] += d[j - money[i]];
            }
        }
        answer = (int) (d[n] % 1000000007);
        return answer;
    }
}