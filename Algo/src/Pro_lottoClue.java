// 프로그래머스 로또의 최고 순위와 최저 순위
public class Pro_lottoClue {

  public static int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];
    int zero = 0;
    int cnt = 0;

    loop:for (int i = 0; i < 6; i++) {
      if (lottos[i] == 0) {
        zero++;
        continue;
      }
      for (int j = 0; j < 6; j++) {
        if (lottos[i] == win_nums[j]) {
          cnt++;
          continue loop;
        }
      }
    }
    answer[0] = 7 - (cnt + zero);
    answer[1] = 7 - cnt;
    if (answer[0] == 7) answer[0] = 6;
    if (answer[1] == 7) answer[1] = 6;
    return answer;
  }

  public static void main(String[] args) {
    int[] lottos = { 1, 2, 0, 0, 5, 6 };
    int[] win_nums = { 1, 2, 3, 4, 5, 6 };
    int[] answer = new int[2];
    answer = solution(lottos, win_nums);
    System.out.println(answer[0] + " " + answer[1]);
  }
}
