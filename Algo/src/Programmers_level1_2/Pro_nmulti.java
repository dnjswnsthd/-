import java.util.*;
/*
* 프로그래머스 > 코딩테스트 연습 > 월간 코드 챌린지 시즌3 > n^2 배열 자르기
* 22.03.14
 */
class Pro_nmulti {
    public static long[] solution(int n, long left, long right) {
        int between = (int) (right - left);
        long[] answer = new long[between + 1];
        int idx = 0;
        for(long i = left; i < right+1; i++){
            answer[idx] = Math.max(i/n, i%n) + 1;
            idx++;
        }
        return answer;
    }
    public static void main(String [] args){
        int n = 3, left = 2, right = 5;
        System.out.println(Arrays.toString(solution(n, left, right)));
    }
}