
package Programmers_level3;
import java.util.*;
/*
* 프로그래머스 > 코딩테스트 연습 > 줄 서는 방법
* 22.03.31
 */
class Pro_reLine {
    public int[] solution(int n, long k) {
        int[] ret = new int[n];
        List<Integer> list = new ArrayList<>();
        long num=1;
        int idx=0;
        for(int x=1 ; x<=n ; x++) {
            list.add(x);
            num *= x;
        }
        k--;
        while(idx<ret.length) {
            num /= (n--);
            int i = (int)(k/num);
            ret[idx++] = list.get(i);
            list.remove(i);
            k %= num;
        }
        return ret;
    }
}