package Programmers_level1_2;

// 프로그래머스 부족한 금액 계산하기
public class Pro_lessMoney {

  public static long solution(int price, int money, int count) {
    int pay = 0;
    for (int i = 1; i <= count; i++) {
      pay += price * i;
    }
    if (pay > money) return pay - money;
    return 0;
  }

  public static void main(String[] args) {
    int price = 3;
    int money = 20;
    int count = 4;
    System.out.println(solution(price, money, count));
  }
}
