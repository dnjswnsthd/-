package Programmers_kit;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� �ڵ��� ��ȣ ������
public class Pro_hidePhone {
    public static String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += '*';
        }
        answer += phone_number.substring(phone_number.length() - 4, phone_number.length());
        return answer;
    }
    public static void main(String[] args) {
        String phone_number = "01033334444";
        System.out.println(solution(phone_number));
    }
}
