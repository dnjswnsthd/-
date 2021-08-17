import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 프로그래머스 코딩테스트 연습 괄호 회전하기

public class Pro_bracketRota {
    public static int solution(String s) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            q.add(s.charAt(i));
        }
        loop:for (int i = 0; i < size; i++) {
            st.clear();
            char c = q.poll();
            q.add(c);
            Queue<Character> q2 = new LinkedList<>(q);
            for (int j = 0; j < size; j++) {
                if (st.empty() && (q2.peek() == ')' || q2.peek() == '}' || q2.peek() == ']')) {
                    continue loop;
                } else if (st.empty() && (q2.peek() == '(' || q2.peek() == '{' || q2.peek() == '[')) {
                    st.add(q2.poll());
                } else if (!st.empty() && q2.peek() == ')') {
                    if (st.peek() == '(') {
                        q2.poll();
                        st.pop();
                    } else {
                        continue loop;
                    }
                } else if (!st.empty() && q2.peek() == '}') {
                    if (st.peek() == '{') {
                        q2.poll();
                        st.pop();
                    } else {
                        continue loop;
                    }
                } else if (!st.empty() && q2.peek() == ']') {
                    if (st.peek() == '[') {
                        q2.poll();
                        st.pop();
                    } else {
                        continue loop;
                    }
                } else if (!st.empty() && (q2.peek() == '(' || q2.peek() == '{' || q2.peek() == '[')) {
                    st.add(q2.poll());
                }
            }
            if (q2.isEmpty() && st.isEmpty())
                answer++;
        }    
         return answer;
    }
    public static void main(String[] args) {
        String s = "}}}";
        System.out.println(solution(s));
    }
}
