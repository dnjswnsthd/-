import java.util.Stack;
// ���α׷��ӽ� �ڵ��׽�Ʈ ���� �ùٸ� ��ȣ
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
