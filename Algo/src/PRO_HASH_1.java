import java.util.HashMap;

//프로그래머스 코딩테스트 연습 해쉬 완주하지 못한 선수 

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