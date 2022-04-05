import java.util.*;
/*
* 코딩테스트 연습 > 월간 코드 챌린지 시즌2 > 110 옮기기
* 22.04.05
 */
class Pro_move110 {
    public String solve(String s){
        int cnt110 = 0;
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            st.push(s.charAt(i));
            if(st.size() >= 3){
                char first = st.pop();
                if(first != '0'){
                    st.push(first);
                    continue;
                }
                char second = st.pop();
                if(second != '1'){
                    st.push(second);
                    st.push(first);
                    continue;
                }
                char third = st.pop();
                if(third != '1'){
                    st.push(third);
                    st.push(second);
                    st.push(first);
                    continue;
                }
                cnt110++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int pos = st.size();
        boolean flag = false;
        while(!st.isEmpty()){
            char pop = st.pop();
            if(!flag && pop == '1') pos--;
            if(pop == '0') flag = true;
            sb.insert(0, pop);
        }
        String fix = "";
        for(int i=0;i<cnt110;i++)
            sb.insert(pos, "110");

        return sb.toString();
    }
    public String[] solution(String[] s) {
        String[] answer = {};
        answer = new String[s.length];
        for(int i=0;i<s.length;i++)
            answer[i] = solve(s[i]);
        return answer;
    }
}