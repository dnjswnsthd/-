package Programmers_level1_2;

import java.util.Arrays;
// 프로그래머스 코딩테스트 연습 N개의 최소공배수
public class Pro_nNumLcm {
    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int tmp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            tmp = lcm(tmp, arr[i]);
        }
        return tmp;
    }
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
   public static void main(String[] args) {
       int[] arr = { 2, 6, 8, 14 };
      System.out.print(solution(arr));
   }
}