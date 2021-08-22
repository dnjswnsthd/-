package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 문자열 다루기 기본
class Pro_strOrd {
    public static boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            if (s.toUpperCase().equals(s) && s.toLowerCase().equals(s))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "a234";
        System.out.println(solution(str));
    }
}