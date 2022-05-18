package Programmers_level3;
import java.util.*;
/*
* 프로그래머스 > 코딩테스트 연습 > dev > 다단계 칫솔 판매
* 22.03.30
 */
class Pro_toothpaste {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> parentMap = new HashMap<>(); // <자신, 부모>
        Map<String, Integer> memberIndexMap = new HashMap<>(); // <자신, 자신의 순서>
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }
        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            int profit = 100 * amount[i];
            while (!now.equals("-")) {
                int profitForParent = profit / 10; // 부모에게 넘겨줄 금액
                int nowProfit = profit - profitForParent; // 자신이 가져갈 금액
                answer[memberIndexMap.get(now)] += nowProfit;
                now = parentMap.get(now);
                profit /= 10;
                if (profit < 1) {
                    break;
                }
            }
        }
        return answer;
    }
}