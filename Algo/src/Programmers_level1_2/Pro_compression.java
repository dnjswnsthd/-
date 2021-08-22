package Programmers_level1_2;

import java.util.ArrayList;
import java.util.HashMap;

// 프로그래머스 코딩테스트 연습 압축

public class Pro_compression {
    public static ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        int idx = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            hs.put(i + "", idx++);
        }
        int size = msg.length();
        for (int i = 0; i < size; i++) {
            int a = 1;
            while (i + a <= size && hs.containsKey(msg.substring(i, i + a))) {
                a++;
            }
            if (i + a > size) {
                answer.add(hs.get(msg.substring(i)));
                break;
            }
            answer.add(hs.get(msg.substring(i, i + a - 1)));
            hs.put(msg.substring(i, i + a), idx++);
            if (a > 1)
                i += a - 2;
        }
        return answer;
    }
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(solution(msg));
    }
}
