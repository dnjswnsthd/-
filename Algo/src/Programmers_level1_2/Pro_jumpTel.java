package Programmers_level1_2;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� �����ϰ� �����̵��ϱ�

public class Pro_jumpTel {
    public static int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }
}
