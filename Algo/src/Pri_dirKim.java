// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ���￡�� �輭�� ã��

public class Pri_dirKim {
    public static String solution(String[] seoul) {
        String answer = "�輭���� ";
        int tmp = 0;
        while (!seoul[tmp].equals("Kim")) {
            tmp += 1;
        }
        return answer + tmp +  "�� �ִ�";
    }
    public static void main(String[] args) {
        String[] seoul = { "Jane", "Kim" };
        System.out.println(solution(seoul));
    }
}
