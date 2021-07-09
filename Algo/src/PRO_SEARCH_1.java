import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 코딩테스트 연습 완전탐색 모의고사

public class PRO_SEARCH_1 {
	public static int[] solution(int[] answers) {
        ArrayList <Integer> answer = new ArrayList<Integer>();
        int [] mathGiveUp1 = {1, 2, 3, 4, 5};
        int [] mathGiveUp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] mathGiveUp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int [] cnt = new int [3];
        for(int i = 0; i < answers.length; i++) {
        	if(answers[i] == mathGiveUp1[i % 5]) {
        		cnt[0]++;
        	}
        	if(answers[i] == mathGiveUp2[i % 8]) {
        		cnt[1]++;
        	}
        	if(answers[i] == mathGiveUp3[i % 10]) {
        		cnt[2]++;
        	}
        }
        int max = Arrays.stream(cnt).max().getAsInt();
        for(int i = 0; i < 3; i++) {
        	if(cnt[i] == max) {
        		answer.add(i + 1);
        	}
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String [] args) {
		int [] a = {1, 3, 2, 4, 2};
		System.out.println(Arrays.toString(solution(a)));
	}
}
