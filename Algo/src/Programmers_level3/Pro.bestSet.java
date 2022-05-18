package Programmers_level3;
/*
* 프로그래머스 > 코딩테스트 연습 > 최고의 집합
* 22.04.01
 */
class Pro_bestSet {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        if (s % n == 0) {
            for (int i = 0; i < n; i++) {
                answer[i] = s / n;
            }
        } else {
            int rem = s % n;
            int po = n - rem;
            for (int i = 0; i < po; i++) {
                answer[i] = s / n;
            }
            for (int i = po; i < n; i++) {
                answer[i] = s / n + 1;
            }
        }
        return answer;
    }
}