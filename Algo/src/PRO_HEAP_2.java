import java.util.Arrays;
import java.util.PriorityQueue;

// 프로그래머스 코딩테스트 연습 힙 디스크 컨트롤러

public class PRO_HEAP_2 {
	public static int solution(int[][] jobs) {
        int answer = 0;
        int cnt = 0, now = 0;
        Arrays.sort(jobs, ((o1, o2)-> o1[0]-o2[0]));
        PriorityQueue<int []> wait = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        int num = 0;
        while(cnt < jobs.length) {
        	while(num < jobs.length && jobs[num][0] <= now) {
        		wait.add(jobs[num++]);
        	}
        	if(wait.isEmpty()) {
        		now = jobs[num][0];
        	}else {
        		int [] ing = wait.poll();
        		answer += ing[1] + now - ing[0];
        		now += ing[1];
        		cnt++;
        	}
        }
        
        return answer / jobs.length;
    }
	public static void main(String [] args) {
		int [][] a = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(a));
	}
}
