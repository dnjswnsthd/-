// 프로그래머스 코딩테스트 연습 시저 암호

public class Pro_sizer {
    public static String solution(String s, int n) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += ' ';
                continue;
            }
            int m = s.charAt(i);
            if (m <= 90) {
                if(m + n > 90)
                    m += n - 26;
                else
                    m += n;  
            } else if (m >= 95) {
                if (m + n > 122) {
                    m += n - 26;
                }else
                    m += n;
            }
            char c = (char) m;
            answer += c;
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        System.out.println(solution(s, n));
    }
}
