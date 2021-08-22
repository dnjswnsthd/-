package Programmers_level1_2;

import java.util.Arrays;

// 프로그래머스 코딩테스트 연습 최솟값 만들기

public class Pro_makeMin {
    public static int solution(int []A, int []B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] A = { 1, 2 };
        int[] B = { 3, 4 };
        System.out.println(solution(A, B));
    }
}
