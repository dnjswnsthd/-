package Programmers_level1_2;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ������ ǥ��

public class Pro_presenNum {
    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            int tmp = i;
            while (sum < n) {
                sum += tmp;
                if (sum == n) {
                    answer++;
                    break;
                }
                tmp++;
            }
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }
}