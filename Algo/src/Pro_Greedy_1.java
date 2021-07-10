// 프로그래머스 코딩테스트 연습 Greedy 체육복 

public class Pro_Greedy_1 {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] students = new int [n + 1];
        loop:for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(lost[i] == reserve[j]) {
        			reserve[j] = 0;
        			continue loop;
        		}
        	}
        	students[lost[i]] = 1;
        }
        for(int i = 0; i < reserve.length; i++) {
        	if(reserve[i] == 0) {
        		continue;
        	}
        	if(reserve[i] == 1 && students[2] == 1) {
        		students[2] = 0;
        		continue;
        	}
        	if(students[reserve[i] - 1] == 1) {
        		students[reserve[i] - 1] = 0;
        	}else if(reserve[i] + 1 < students.length && students[reserve[i] + 1] == 1) {
        		students[reserve[i] + 1] = 0;
        	}
        }
        for(int i = 1; i < students.length; i++) {
        	if(students[i] == 0) {
        		answer++;
        	}
        }
        return answer;
    }
	public static void main(String [] args) {
		int a = 3;
		int [] b = {3};
		int [] c = {1};
		System.out.println(solution(a, b, c));
	}
}
