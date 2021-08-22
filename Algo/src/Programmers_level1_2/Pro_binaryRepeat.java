package Programmers_level1_2;

import java.util.Arrays;
import java.util.Stack;
// 프로그래머스 코딩테스트 연습 이진 변환 반복
public class Pro_binaryRepeat {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int cntZero = 0;
        int cntConvert = 0;
        Stack<Character> st = new Stack<>();
        while (!s.equals("1")) {
            st.clear();
            cntConvert++;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    st.add(s.charAt(i));
                } else {
                    cntZero++;
                }
            }
            s = Integer.toBinaryString(st.size());
        }
        answer[0] = cntConvert;
        answer[1] = cntZero;
        return answer;
    }
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));
    }
}
