package Programmers_level1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 코딩테스트 연습 영어 끝말잇기

public class Pro_english {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        boolean chk = false;
        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                chk = true;
                break;
            }
            list.add(words[i]);
            if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                chk = true;
                break;
            }
        }
        if (!chk) {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(n, words)));
    }
}
