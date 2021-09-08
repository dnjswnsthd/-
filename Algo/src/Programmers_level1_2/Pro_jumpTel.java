package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 점프하고 순간이동하기

public class Pro_jumpTel {
    public static int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }
}
