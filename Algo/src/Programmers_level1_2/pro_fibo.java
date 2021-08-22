package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 피보나치 수

public class pro_fibo {
    public static int solution(int n) {
        int answer = 0;
        int[] fibo = new int[n+1];
        if (n == 1)
            return 1;
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 2] % 1234567 + fibo[i - 1] % 1234567;
        }
        return fibo[n] % 1234567;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }
}
