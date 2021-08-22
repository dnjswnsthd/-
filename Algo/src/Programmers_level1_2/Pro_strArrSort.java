package Programmers_level1_2;

import java.util.Arrays;
import java.util.PriorityQueue;

// 프로그래머스 연습문제 문자열 내 마음대로 정렬하기

public class Pro_strArrSort {
    public static String[] solution(String[] strings, int n) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];
            pq.add(strings[i]);
        }
        int size = pq.size();
        String[] answer = new String[size];
        for (int i = 0; i < size; i++) {
            answer[i] = pq.poll();
            answer[i] = answer[i].substring(1, answer[i].length());
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] strings = { "abce", "abcd", "cdx" };
        int n = 1;
        System.out.println(Arrays.toString(solution(strings, n)));
    }
}
