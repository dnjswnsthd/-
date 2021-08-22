package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 n진수 게임

public class Pro_nConversion {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String allStr = "0";
        int tmpNum = 1;
        while (answer.length() != t) {
            allStr += conversion(tmpNum, n);
            tmpNum++;
            if (allStr.length() > p) {
                answer += allStr.charAt(p - 1);
                p += m;
            }
        }
        return answer;
    }

    public static String conversion(int num, int n) {
        int cur = num;
        StringBuilder sb = new StringBuilder();
        while (cur > 0) {
            if (cur % n < 10) {
                sb.append(cur % n);
            } else {
                sb.append(((char) (cur % n - 10 + 'A')));
            }
            cur /= n;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 16, t = 16, m = 2, p = 1;
        System.out.println(solution(n, t, m, p));
    }
}