import java.util.Arrays;
// 프로그래머스 코딩테스트 연습 x만큼 간격이 있는 n개의 숫자
public class Pro_xdirN {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        long tmp = x;
        for (int i = 1; i <= n; i++) {
            answer[i - 1] = tmp * i;
        }
        return answer;
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(solution(x, n)));
    }
}
