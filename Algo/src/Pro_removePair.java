import java.util.Stack;

// ���α׷��ӽ� ¦���� �����ϱ�
class Pro_removePair {
  public static int solution(String s) {
    Stack<Character> st = new Stack<>();
    st.push(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      if (!st.isEmpty() && st.peek() == s.charAt(i)) {
        st.pop();
      } else st.push(s.charAt(i));
    }
    if (st.size() == 0) return 1; else return 0;
  }
  public static void main(String[] args) {
    String s = "baabaa";
    System.out.println(solution(s));
  }
}
