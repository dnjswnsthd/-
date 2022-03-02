package Programmers_level1_2;
/*
* ���α׷��ӽ� �ڵ��׽�Ʈ ���� 2022 KAKO BLIND > �Ű� ��� �ޱ�
* 2022.03.02
*/
import java.util.*;

public class Pro_result {
    public int[] solution(String[] id_list, String[] report, int k) {
        report = Arrays.stream(report).distinct().toArray(String[]::new); /* �ߺ� ���� */
        int[] answer = new int[id_list.length];
        Map<String, Integer> map = new LinkedHashMap<>(); /* ���� ���� */
        Map<String, ArrayList<String>> listMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], 0);
        }
        for (int i = 0; i < report.length; i++) {
            String[] strArr = report[i].split(" ");
            String to = strArr[0];
            String from = strArr[1];
            if (listMap.containsKey(from)) {
                listMap.get(from).add(to);
            } else {
                ArrayList<String> arrList = new ArrayList<>();
                arrList.add(to);
                listMap.put(from, arrList);
            }
        }
        for (String s : listMap.keySet()) {
            if (listMap.get(s).size() >= k) {
                for (String ss : listMap.get(s)) {
                    map.put(ss, map.getOrDefault(ss, 0) + 1);
                }
            }
        }
        answer = map.values().stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
