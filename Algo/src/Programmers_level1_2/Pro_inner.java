package Programmers_level1_2;

// 프로그래머스 내적
public class Pro_inner {
    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { -3, -1, 0, 2 };
        System.out.println(solution(a, b));
    }
}
