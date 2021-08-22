package Programmers_level1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 프로그래머스 코딩테스트 연습 메뉴 리뉴얼
class Pro_menuRenewal {
    private static ArrayList <String> combination;
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        combination = new ArrayList<>();
        for(int i = 0; i < orders.length; i++){
            char [] orderSplit = orders[i].toCharArray();
            Arrays.sort(orderSplit);
            for(int j = 0; j < orderSplit.length - 1; j++){
                for(int k = 0; k < course.length; k++){
                    dfs(orderSplit, j, 1, course[k], String.valueOf(orderSplit[j]));
                }
            }   
        }
        Map <String, Integer> map = new HashMap<>();
        for (String key : combination) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<String> set = new ArrayList<>(map.keySet());
        Collections.sort(set, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int max_value = 0;
            for (String key : set) {
                if (map.get(key) >= 2 && key.length() == course[i]) {
                    if (map.get(key) >= max_value) {
                        ansList.add(key);
                        max_value = map.get(key);
                    }
                }
            }
        }
        Collections.sort(ansList);
        answer = new String[ansList.size()];
        ansList.toArray(answer);

        return answer;  
    }
    private static void dfs(char[] orderSplit, int j, int i, int k, String str) {
        if (i == k) { 
            combination.add(str);
        }
        for (int idx = j + 1; idx < orderSplit.length; idx++) {
            dfs(orderSplit, idx, i + 1, k, str + orderSplit[idx]);
        }
    }
    public static void main(String [] args){
        String [] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] course = {2, 3, 4};
        String [] res = solution(orders, course);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + ", ");
        }
    }
}