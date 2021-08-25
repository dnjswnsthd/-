package Programmers_level1_2;

import java.util.ArrayList;
import java.util.Collections;

//프로그래머스 코딩테스트 연습 위클리 챌린지 4주차

public class Pro_4weeks {
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        String[][] score = new String[table.length][6];
        ArrayList<String> sort = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < table.length; i++) {
            score[i] = table[i].split(" ");
        }
        for (int i = 0; i < score.length; i++) {
            int tmp = 0;
            loop:for (int j = 1; j < score[i].length; j++) {
                for (int k = 0; k < languages.length; k++) {
                    if (score[i][j].equals(languages[k])) {
                        tmp += (6 - j) * preference[k];
                        continue loop;
                    }
                }
            }
            if (tmp > max) {
                max = tmp;
                answer = score[i][0];
            } else if (tmp == max) {
                sort.clear();
                sort.add(answer);
                sort.add(score[i][0]);
                Collections.sort(sort);
                if (sort.get(0).equals(score[i][0])) {
                    answer = score[i][0];
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA" };
        String[] languages = { "PYTHON", "C++", "SQL" };
        int[] preference = { 7, 5, 5 };
        System.out.println(solution(table, languages, preference));
    }
}