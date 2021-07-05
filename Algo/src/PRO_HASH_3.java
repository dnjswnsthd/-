import java.util.HashMap;
import java.util.Set;

// 프로그래머스 코딩테스트 연습 해쉬 위장

public class PRO_HASH_3 {
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap <String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        Set<String> set = map.keySet();
        for(String key : set) {
        	answer *= map.get(key) + 1;
        }
        return answer - 1;
    }
}
