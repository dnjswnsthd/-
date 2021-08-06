import java.util.Collections;
import java.util.PriorityQueue;

// 프로그래머스 코딩테스트 연습 문자열 내림차순으로 배치하기

public class Pro_descStr {
    public static String solution(String s) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i); 
            pq.add(n);
        }
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            int m = pq.poll();
            char c = (char)m;
            answer += c;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }
}
