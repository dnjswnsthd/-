import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 코딩테스트 연습 스택/큐 다리를 지나는 트럭

public class PRO_STQU_3 {
	public static int solution(int bridgeLength, int weight, int[] truckWeights) {
		int answer = 0;
		int sum = 0;
		Queue<Integer> bridge = new LinkedList<Integer>();
		Queue<Integer> truck = new LinkedList<Integer>();
		for (int i = 0; i < truckWeights.length; i++) {
			truck.offer(truckWeights[i]);
		}
		while (!truck.isEmpty()) {
			answer++;
			if (sum + truck.peek() <= weight && bridge.size() < bridgeLength) {
				sum += truck.peek();
				bridge.offer(truck.poll());
			} else if (sum + truck.peek() <= weight && bridge.size() == bridgeLength) {
				sum -= bridge.peek();
				bridge.poll();
				if (sum + truck.peek() > weight) {
					bridge.offer(0);
				} else {
					sum += truck.peek();
					bridge.offer(truck.poll());
				}
			} else if (sum + truck.peek() > weight && bridge.size() < bridgeLength) {
				bridge.offer(0);
			} else if (sum + truck.peek() > weight && bridge.size() == bridgeLength) {
				sum -= bridge.peek();
				bridge.poll();
				if (sum + truck.peek() > weight) {
					bridge.offer(0);
				} else {
					sum += truck.peek();
					bridge.offer(truck.poll());
				}
			}
		}
		return answer + bridgeLength;
	}

	public static void main(String[] args) {
		int a = 100;
		int b = 100;
		int[] c = {10,10,10,10,10,10,10,10,10,10};
		System.out.println("ㅎㅇ : " + solution(a, b, c));
	}
}
