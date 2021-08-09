// 프로그래머스 코딩테스트 연습 짝수와 홀수
public class Pro_oddEven {
    public static String solution(int num) {
        if (num % 2 == 1 || num % 2 == -1)
            return "Odd";
        else
            return "Even";
    }
    public static void main(String[] args) {
        int num = -9;
        System.out.println(solution(num));
    }
}
