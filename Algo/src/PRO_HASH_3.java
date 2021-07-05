import java.util.HashMap;
import java.util.Set;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� �ؽ� ����

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
