// ���α׷��ӽ� �ڵ��׽�Ʈ ���� �ݶ��� ����

public class Pro_collatz {
    public static int solution(long num) {
        int tmp = 0;
        while (tmp <= 500) {
            if (num == 1)
                break;
            tmp++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = (num * 3) + 1;
            }
        }
        if (tmp > 500) {
            return -1;
        }
        return tmp;
    }
    public static void main(String[] args) {
        long num = 626331;
        System.out.println(solution(num));
    }
}
