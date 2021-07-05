import java.util.HashMap;

//���α׷��ӽ� �ڵ��׽�Ʈ ���� �ؽ� �������� ���� ���� 

class PRO_HASH_1 {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap <String, Integer> map = new HashMap<>();
        for(String par : participant){
            map.put(par, map.getOrDefault(par, 0) + 1);
        }
        for(String com : completion) {
        	map.put(com, map.get(com) - 1);
        }
        for(String key : map.keySet()) {
        	if(map.get(key) != 0) {
        		return key;
        	}
        }
        return null;
    }
}