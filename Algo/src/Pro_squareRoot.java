// 프로그래머스 코딩테스트 연습 정수 제곱근 판별

public class Pro_squareRoot {
    public static long solution(long n) {
        Double m = Math.sqrt(n);
        if (m == Math.ceil(m)) {
            long res = (new Double((m + 1) * (m + 1))).longValue();
            return res;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        long n = 121;
        System.out.println(solution(n));
    }
}
