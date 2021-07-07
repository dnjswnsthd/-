import java.util.PriorityQueue;

public class PRO_HEAP_1 {
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        int sum = 0;
        PriorityQueue <Integer> sco = new PriorityQueue <Integer>();
        for(int i = 0; i < scoville.length; i++) {
        	sco.add(scoville[i]);
        }
        if(sco.peek() >= K) return 0;
        while(sco.size() > 1) {
        	sum = 0;
        	sum = sco.poll() + (sco.poll ()* 2);
        	sco.add(sum);
        	if(sco.peek() >= K) {
        		answer++;
        		return answer;
        	}else if(sum == K) {
        		return answer - 1;
        	}
        	answer++;
        }
        return -1;
    }
	public static void main(String [] args) {
		int [] a = {1, 2, 3, 9, 10, 12};
		int b = 7;
		System.out.println(solution(a,b));
	}
}
