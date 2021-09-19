package Programmers_level1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 코딩테스트연습 7주차 입실 퇴실

public class Pro_7weeks {
    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        List<Integer> list = new ArrayList();
        int idx = 0;
        for (int i = 0; i < answer.length; i++) {
            list.add(enter[i]);
            for (int j = 0; j < list.size(); j++) {
                if (enter[i] == list.get(j)) {
                    answer[list.get(j) - 1] = list.size() - 1;
                } else {
                    answer[list.get(j) - 1]++;
                }
            }
            while (idx < answer.length && list.contains(leave[idx])) {
                list.remove(Integer.valueOf(leave[idx++]));
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] enter = { 1, 3, 2 };
        int[] leave = { 1, 2, 3 };
        System.out.println(Arrays.toString(solution(enter, leave)));
    }
}
