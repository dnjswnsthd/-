package Programmers_level1_2;

import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 코딩테스트 연습 튜플

public class Pro_tupple {
    public static int[] solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        s = s.substring(2, s.length() - 1);
        String[] arr = s.split(",\\{");
        int[] answer = new int[arr.length];

        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i].substring(0, arr[i].length() - 1);

        for (int i = 0; i < arr.length; i++) {
            String[] sub = arr[i].split(",");
            for (String j : sub) {
                int num = Integer.parseInt(j);
                if (!list.contains(num))
                    list.add(num);
            }
        }

        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(solution(s)));
    }
}
