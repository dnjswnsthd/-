// 프로그래머스 키패드 누르기

public class Pro_keypad {

  public static String solution(int[] numbers, String hand) {
    String answer = "";
    int lX = 0, lY = 0, rX = 2, rY = 0;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 1) {
        answer += "L";
        lX = 0;
        lY = 3;
      } else if (numbers[i] == 4) {
        answer += "L";
        lX = 0;
        lY = 2;
      } else if (numbers[i] == 7) {
        answer += "L";
        lX = 0;
        lY = 1;
      } else if (numbers[i] == 3) {
        answer += "R";
        rX = 2;
        rY = 3;
      } else if (numbers[i] == 6) {
        answer += "R";
        rX = 2;
        rY = 2;
      } else if (numbers[i] == 9) {
        answer += "R";
        rX = 2;
        rY = 1;
      } else if (numbers[i] == 2) {
        int tmpL = Math.abs(lY - 3) + Math.abs(lX - 1);
        int tmpR = Math.abs(rY - 3) + Math.abs(rX - 1);
        if (tmpL > tmpR) {
          answer += "R";
          rX = 1;
          rY = 3;
        } else if (tmpL < tmpR) {
          answer += "L";
          lX = 1;
          lY = 3;
        } else {
          if (hand.equals("left")) {
            answer += "L";
            lX = 1;
            lY = 3;
          } else {
            answer += "R";
            rX = 1;
            rY = 3;
          }
        }
      } else if (numbers[i] == 5) {
        int tmpL = Math.abs(lY - 2) + Math.abs(lX - 1);
        int tmpR = Math.abs(rY - 2) + Math.abs(rX - 1);
        if (tmpL > tmpR) {
          answer += "R";
          rX = 1;
          rY = 2;
        } else if (tmpL < tmpR) {
          answer += "L";
          lX = 1;
          lY = 2;
        } else {
          if (hand.equals("left")) {
            answer += "L";
            lX = 1;
            lY = 2;
          } else {
            answer += "R";
            rX = 1;
            rY = 2;
          }
        }
      } else if (numbers[i] == 8) {
        int tmpL = Math.abs(lY - 1) + Math.abs(lX - 1);
        int tmpR = Math.abs(rY - 1) + Math.abs(rX - 1);
        if (tmpL > tmpR) {
          answer += "R";
          rX = 1;
          rY = 1;
        } else if (tmpL < tmpR) {
          answer += "L";
          lX = 1;
          lY = 1;
        } else {
          if (hand.equals("left")) {
            answer += "L";
            lX = 1;
            lY = 1;
          } else {
            answer += "R";
            rX = 1;
            rY = 1;
          }
        }
      } else if (numbers[i] == 0) {
        int tmpL = Math.abs(lY - 0) + Math.abs(lX - 1);
        int tmpR = Math.abs(rY - 0) + Math.abs(rX - 1);
        if (tmpL > tmpR) {
          answer += "R";
          rX = 1;
          rY = 0;
        } else if (tmpL < tmpR) {
          answer += "L";
          lX = 1;
          lY = 0;
        } else {
          if (hand.equals("left")) {
            answer += "L";
            lX = 1;
            lY = 0;
          } else {
            answer += "R";
            rX = 1;
            rY = 0;
          }
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
    String hand = "right";
    System.out.println(solution(numbers, hand));
  }
}
