// 프로그래머스 코딩테스 연습 이상한 문자 만들기
public class Pro_OrdiChar {
    public static String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                if (j % 2 == 0) {
                    answer += str[i].toUpperCase().charAt(j);
                } else {
                    answer += str[i].toLowerCase().charAt(j);
                }
            }
            answer += " ";
        }
        answer = answer.substring(0, answer.length() - 1);
        answer += s.substring(answer.length(), s.length());
        return answer;
    }

    public static void main(String[] args) {
        String s = "try  hello world   ";
        System.out.println(solution(s));
    }
}
