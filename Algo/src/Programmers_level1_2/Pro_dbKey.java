package Programmers_level1_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 프로그래머스 코딩테스트 연습 후보키

public class Pro_dbKey {
    public static int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= (1 << m) - 1; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                // 비트마스크
                for (int k = 0; k < m; k++) {
                    if ((i & (1 << k)) > 0) {
                        sb.append(relation[j][k]);
                    }
                }
                set.add(sb.toString());
            }
            if (set.size() == n && check(answer, i)) {
                answer.add(i);
            }
        }
        return answer.size();
    }
    //최소성검사
    public static boolean check(List<Integer> answer, int now) { 
        for (int i = 0; i < answer.size(); i++) {
            if ((answer.get(i) & now) == answer.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
                { "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
                { "600", "apeach", "music", "2" } };
        System.out.println(solution(relation));
    }
}
