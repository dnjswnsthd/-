package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 JadenCase 문자열 만들기

public class Pro_JadenCase {
    public static String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        System.out.println(str.length);
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            sum += str[i].length();
            if (str[i].equals("")) {
                answer += " ";
                continue;
            }
            answer += str[i].substring(0, 1).toUpperCase();
            answer += str[i].substring(1, str[i].length()).toLowerCase();
            answer += " ";
        }
        sum += str.length - 1;
        if (s.length() != sum) {
            for (int i = 0; i < s.length() - sum; i++) {
                answer += " ";
            }
        }
        return answer.substring(0, answer.length()-1);
    }
    public static void main(String[] args) {
        String s = "a b ";
        System.out.println(solution(s));
    }
}
