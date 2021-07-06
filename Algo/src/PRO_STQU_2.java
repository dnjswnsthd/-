import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 코딩테스트 연습 스택/큐 프린터

public class PRO_STQU_2 {
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue <Printer> print = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
        	print.offer(new Printer(i, priorities[i]));
        }
        while(!print.isEmpty()) {
        	int chk = 0;
        	int prioritie = print.peek().prioritie;
        	for(Printer p : print) {
        		if(prioritie < p.prioritie) {
        			chk = 1;
        		}
        	}
        	if(chk == 1) {
        		print.offer(print.poll());
        	}else {
        		if(print.poll().location == location) {
        			answer = priorities.length - print.size();
        		}
        	}
        }
        return answer;
    }
	public static void main(String [] args) {
		int [] a = {1, 1, 9, 1, 1, 1};
		int b = 0;
		System.out.println(solution(a, b));
	}
	
	static class Printer {
		int location;
		int prioritie;
		Printer(int location, int prioritie){
			this.location = location;
			this.prioritie = prioritie;
		}
	}
}
