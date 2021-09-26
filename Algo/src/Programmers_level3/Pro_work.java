package Programmers_level3;

import java.util.Arrays;

// 프로그래머스 코딩테스트 연습 야근 지수

public class Pro_work {
    public static long solution(int n, int[] works) {
        long answer = 0;
        int sum = 0;
        for (int i = 0; i < works.length; i++)
            sum += works[i];
        if (n >= sum)
            return 0;
        while (n != 0) {
            Arrays.sort(works);
            works[works.length - 1]--;
            n--;
        }

        for (int i = 0; i < works.length; i++) {
            answer += (works[i] * works[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] works = { 4, 3, 3 };
        int n = 4;
        System.out.println(solution(n, works));
    }
}
