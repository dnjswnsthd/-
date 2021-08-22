package Programmers_level1_2;

import java.math.BigInteger;
// 프로그래머스 멀쩡한 사각형
public class Pro_niceSqu {
    public static long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w, h));
    }
}
