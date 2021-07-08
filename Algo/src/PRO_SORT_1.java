import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 프로그래머스 코딩테스트 연습 정렬 K번쨰수

public class PRO_SORT_1 {
	public static int[] solution(int[] array, int[][] commands) {
        ArrayList <Integer> answer = new ArrayList<>();
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < commands.length; i++) {
        	for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
        		pq.offer(array[j]);
        	}
        	for(int j = 0; j < commands[i][2] - 1; j++) {
        		pq.poll();
        	}
        	answer.add(pq.poll());
        	pq.clear();
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String [] args) {
		int [] a = {1, 5, 2, 6, 3, 7, 4};
		int [][] b = {{2,5,3}, {4,4,1}, {1,7,3}};
		System.out.println(Arrays.toString(solution(a,b)));
	}
}
