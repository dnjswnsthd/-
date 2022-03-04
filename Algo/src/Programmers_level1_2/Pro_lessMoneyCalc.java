package Programmers_level1_2;
/*
* 코딩테스트 연습 > 위클리 챌린지 > 부족한 금액 계산하기
* 2022.03.04
*/
public class Pro_lessMoneyCalc {
    public static long solution(int price, int money, int count) {
        long pay = 0;
        for (int i = 1; i <= count; i++) {
          pay += price * i;
        }
        if (pay > money) return pay - money;
        return 0;
      }
}
