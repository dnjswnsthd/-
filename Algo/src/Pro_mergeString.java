import java.util.ArrayList;
import java.util.PriorityQueue;

// 프로그래머스 코딩테스트 연습 2020 KAKAO BLIND TEST 문자열 압축
public class Pro_mergeString {
	public static int solution(String s) {
		PriorityQueue <Integer> answer = new PriorityQueue<Integer>();
		ArrayList<String> tmp;
		if(s.length() == 1) return 1;// 길이가 1일때 (이런 경우 생각잘하자!!)
		for (int i = 1; i <= s.length() / 2; i++) {
			tmp = new ArrayList<String>();
			int jtmp = 0;
			for (int j = 0; j < s.length(); j = j + i) {
				if(j + i <= s.length()) {
					tmp.add(s.substring(j, j + i));
				}
				else {
					tmp.add(s.substring(jtmp, s.length()));
				}
				jtmp = j + i;
			}
			String [] str = new String[tmp.size()];
			str = tmp.toArray(str);
			int sum = 0;
			int roop = 0;
			for(int j = 0; j < str.length; j = j + roop) {
				roop = 1;
				while(j+roop < str.length && str[j].equals(str[j+roop])) {
					roop += 1;
				}
				if(roop < 2) sum += roop * tmp.get(j).length();
				else if(roop >= 10) sum += tmp.get(j).length() + 2;
				else sum += tmp.get(j).length() + 1;
			}
			answer.add(sum);
		}
		return answer.poll();
	}
	public static void main(String [] args) {
		String s = "a";
		System.out.println(solution(s));
	}
}
