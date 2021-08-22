package Programmers_level1_2;

// ���α׷��ӽ� ����� ������ ����
public class Pro_diviAdd {
    public static int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int left = 24;
        int right = 27;
        System.out.println(solution(left, right));
    }
}
