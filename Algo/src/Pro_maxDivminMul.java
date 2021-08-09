import java.util.Arrays;
// ���α׷��ӽ� �ڵ��׽�Ʈ ���� �ִ������� �ּҰ����
public class Pro_maxDivminMul {
    public static int[] solution(int n, int m) {
        int[] answer = new int [2];
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);
        return answer;
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
        int n = 3;
        int m = 12;
        System.out.println(Arrays.toString(solution(n, m)));
    }
}