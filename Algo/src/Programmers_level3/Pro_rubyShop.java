package Programmers_level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * 프로그래머스 level3 보석 쇼핑
 * 22.06.15
 * Set에 넣은 후 비워가면서 체크하는 경우 시간 초과 
 */
public class Pro_rubyShop {
	public static int[] solution(String[] gems) {
		int length = gems.length;
		int start = 0;
		int realstart = 0;
		int end = gems.length;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) { // 초기작업
			if (!map.containsKey(gems[i])) {
				map.put(gems[i], 1);
			} else {
				map.put(gems[i], map.get(gems[i]) + 1);
			}
		}
		int answerLength = map.size();// 구매할 보석갯수
		map.clear();
		Queue<String> q1 = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			if (!map.containsKey(gems[i])) {
				map.put(gems[i], 1);
			} else {
				map.put(gems[i], map.get(gems[i]) + 1);
			}
			q1.add(gems[i]);
			while (!q1.isEmpty()) {
				String left = q1.peek();
				int check = map.get(left);
				if (check >= 2) { // 두개이상 들어가있다.
					map.put(left, map.get(left) - 1);
					q1.poll();
					start++;
				} else { // 1개거나 0개다
					break;
				}
			}
			if (map.size() == answerLength && end > q1.size()) {
				end = q1.size();
				realstart = start;
			}
		}
		int[] answer = { realstart + 1, realstart + end };
		return answer;
	}
//	public int[] solution(String[] gems) {
//		int[] answer = new int [2];
//		answer[1] = Integer.MAX_VALUE;
//		Set<String> set = new HashSet<>();
//		Set<String> tmpSet = new HashSet<>();
//		for (int i = 0; i < gems.length; i++) {
//			set.add(gems[i]);
//		}
//		for (int i = 0; i < gems.length - set.size() + 1; i++) {
//			tmpSet = new HashSet<>(set);
//			int j = i;
//			while(j != gems.length) {
//				tmpSet.remove(gems[j]);
//				if(tmpSet.isEmpty()) {
//					if(j - i < answer[1] - answer[0]) {
//						answer[0] = i;
//						answer[1] = j;
//					}
//					break;
//				}
//				j++;
//			}
//		}
//		++answer[0];
//		++answer[1];
//		return answer;
//	}
}
