import java.util.Arrays;
// ���α׷��ӽ� �ڵ��׽�Ʈ ���� x��ŭ ������ �ִ� n���� ����
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
