package Programmers_level1_2;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ����� ��
public class Pro_divSum {
    public static int solution(int n) {
        int answer = 0;
        answer += n;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 12;
        System.out.println(solution(n));
    }
}
