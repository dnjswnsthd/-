package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 예상 대진표

public class Pro_vsPre {
    public static int solution(int n, int a, int b) {
        int answer = 1;
        int l = 0;
        int r = 0;

        if (a > b) {
            l = b;
            r = a;
        } else {
            l = a;
            r = b;
        }
        while (true) {
            if (l % 2 != 0 && r - l == 1) {
                break;
            }

            l = (l + 1) / 2;
            r = (r + 1) / 2;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution(n, a, b));
    }
}
