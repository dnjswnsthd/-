package Programmers_level1_2;

// ���α׷��ӽ� ��� ���� ��������
public class Pro_centerWord {
    public static String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0) {
            answer += s.charAt((s.length() / 2) - 1);
            answer += s.charAt((s.length() / 2));
        } else {
            answer += s.charAt((s.length() - 1) / 2);
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(solution(s));
    }
}
