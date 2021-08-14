import java.util.Stack;
// 프로그래머스 코딩테스트 연습 올바른 괄호
public class Pro_collect {
    public static boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        if (s.charAt(0) == ')')
            return false;
        if (s.length() % 2 == 1)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push('(');
            else {
                if (st.isEmpty())
                    return false;
                else
                    st.pop();    
            }
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }
}
