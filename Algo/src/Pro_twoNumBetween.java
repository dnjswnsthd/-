// 프로그래머스 코딩테스트 연습 두 정수 사이의 합
public class Pro_twoNumBetween {
    public static long solution(int a, int b) {
        long answer = 0;
        if (a < b) {
            for (int i = a; i <= b; i++) {
                answer += i;
            }
            return answer;
        } else {
            for (int i = b; i <= a; i++) {
                answer += i;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        System.out.println(solution(a, b));
    }
}
