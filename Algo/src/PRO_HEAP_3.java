import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 프로그래머스 코딩테스트 연습 힙 이중우선순위큐

public class PRO_HEAP_3 {
	public static int[] solution(String[] operations) {
		int [] answer = {0, 0};
		StringTokenizer st;
		PriorityQueue<Integer> op1 = new PriorityQueue<>();
		PriorityQueue<Integer> op2 = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < operations.length; i++) {
			if (operations[i].charAt(0) == 'I') {
				st = new StringTokenizer(operations[i]);
				st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				op1.offer(n);
				op2.offer(n);
			} else if (operations[i].equals("D 1") && !op1.isEmpty()) {
				int max = op2.poll();
				op1.remove(max);
			} else if (operations[i].equals("D -1") && !op1.isEmpty()) {
				int min = op1.poll();
				op2.remove(min);
			}
		}
		if(op1.isEmpty()) {
			answer[0] = 0; answer[1] = 0;
		}else {
			answer[0] = op2.poll();
			answer[1] = op1.poll();
		}

		return answer;
	}
	public static void main(String [] args) {
		String [] a = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		System.out.println(Arrays.toString(solution(a)));
	}
}
