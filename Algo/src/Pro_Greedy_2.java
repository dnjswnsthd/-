// 프로그래머스 코딩테스트 연습 Greedy 조이스틱

public class Pro_Greedy_2 {
	public static int solution(String name) {
		int answer = 0;
		int min = name.length() - 1;
		for (int i = 0; i < name.length(); i++) {
			if (Math.abs('Z' - name.charAt(i)) >= Math.abs(name.charAt(i) - 'A')) {
				answer += Math.abs(name.charAt(i) - 'A');
			} else {
				answer += 'Z' - Math.abs(name.charAt(i)) + 1;
			}
			int tmp = i + 1;
			while(tmp < name.length() - 1 && name.charAt(tmp) == 'A') 
				tmp++;
			if(i + name.length() - tmp + i < min) {
				min = i + name.length() - tmp + i;
			}
		}
		answer += min;
		return answer;
	}

	public static void main(String[] args) {
		String a = "ABAAAAAAAABB";
		System.out.println(solution(a));
	}
}
