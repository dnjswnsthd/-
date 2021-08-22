package Programmers_level1_2;

import java.util.Stack;

// 프로그래머스 코딩테스트 연습 괄호 변환

public class Pro_reChk {
    static int tmp;

    public static String solution(String p) {
        if (p.isEmpty())
            return p;
        boolean chk = Chk(p);
        String u = p.substring(0, tmp);
        String v = p.substring(tmp, p.length());
        if (chk) {
            return u + solution(v);
        }
        String answer = "(" + solution(v) + ")";
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(')
                answer += ")";
            else
                answer += "(";
        }
        return answer;
    }

    static boolean Chk(String s) {
        boolean b = true;
        int l = 0, r = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
                st.push('(');
            } else {
                r++;
                if (st.isEmpty()) {
                    b = false;
                } else {
                    st.pop();
                }
            }
            if (l == r) {
                tmp = i + 1;
                return b;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(solution(p));
    }
}
