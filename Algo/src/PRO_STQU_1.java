import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 프로그래머스 코딩테스트 연습 스택/큐 기능개발

public class PRO_STQU_1 {
	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int cnt = 0;
		Stack<Integer> stPro = new Stack<Integer>();
		Stack<Integer> stSpe = new Stack<Integer>();
		for (int i = (progresses.length - 1); i >= 0; i--) {
			stPro.push(progresses[i]);
			stSpe.push(speeds[i]);
		}
		while (!stPro.isEmpty()) {
			cnt = 0;
			for (int j = stPro.size() - 1; j >= 0; j--) {
				stPro.set(j, stPro.get(j) + stSpe.get(j));
			}
			if (stPro.peek() >= 100) {
				cnt++;
				stPro.pop();
				stSpe.pop();
				while (!stPro.isEmpty()) {
					if (stPro.peek() >= 100) {
						cnt++;
						stPro.pop();
						stSpe.pop();
					} else {
						break;
					}
				}

				answer.add(cnt);
			}
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		int[] a = { 95, 90, 99, 99, 80, 99};
		int[] b = { 1, 1, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(solution(a, b)));
	}
}
