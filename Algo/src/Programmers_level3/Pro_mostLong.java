package Programmers_level3;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ���� �� �Ӹ����

public class Pro_mostLong {
    public static int solution(String s) {
        char[] c = s.toCharArray();
        for (int i = s.length(); i > 1; i--) {
            for (int start = 0; start + i <= s.length(); start++) {
                boolean chk = true;
                for (int j = 0; j < i / 2; j++) {
                    if (c[start + j] != c[start + i - j - 1]) {
                        chk = false;
                        break;
                    }
                }
                if (chk)
                    return i;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(solution(s));
    }
}
