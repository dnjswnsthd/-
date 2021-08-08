// 프로그래머스 코딩테스트 연습 서울에서 김서방 찾기

public class Pri_dirKim {
    public static String solution(String[] seoul) {
        String answer = "김서방은 ";
        int tmp = 0;
        while (!seoul[tmp].equals("Kim")) {
            tmp += 1;
        }
        return answer + tmp +  "에 있다";
    }
    public static void main(String[] args) {
        String[] seoul = { "Jane", "Kim" };
        System.out.println(solution(seoul));
    }
}
