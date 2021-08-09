// 프로그래머스 코딩테스트 연습 자릿수 더하기
public class Pro_addDigit {
    public static int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i, i + 1);
            answer += Integer.parseInt(tmp);
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 123;
        System.out.println(solution(n));
    }
}