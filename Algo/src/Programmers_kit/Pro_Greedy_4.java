package Programmers_kit;

import java.util.Arrays;

//프로그래머스 코딩테스트 연습 고득점 킷 그리디4

public class Pro_Greedy_4 {
	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		int answer = 0;
	    int tmp = 0;
	    for(int i = people.length - 1; i >= tmp; i--) {
	    	answer++;
	    	if(people[tmp] + people[i] > limit) continue;
	    	tmp++;
	    }
	    return answer;
    }
	public static void main(String [] args) {
		int [] a = {70, 50, 80, 50};
		int b = 100;
		System.out.println(solution(a, b));
	}
}