// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ���ڼ���?
public class Pro_waterMelon {
    public static String solution(int n) {
        String answer = "";
        String[] waterMelon = { "��", "��" };
        answer += "��";
        for(int i = 1; i < n; i++){
            answer += waterMelon[i % 2];
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}
