package Programmers_kit;

import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 코딩테스트 연습 스택/큐 주식가격
// 각각 앞에서부터 뒤에것과 비교하며 떨어질 떄까지 소요시간을 구함
// break전에 소요시간을 추가해줘야 떨어질 떄까지 쇼요시간이 됨 (유의사항)

public class PRO_STQU_4 {
	public static int[] solution(int[] prices) {
        ArrayList <Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i < prices.length - 1; i++) {
        	int j = i + 1;
        	int cnt = 0;
        	while(j < prices.length) {
        		if(prices[i] > prices[j]) { cnt++; break;}
        		cnt++;
        		j++;
        	}
        	if(cnt == 0) {
        		answer.add(1);
        	}else {
        		answer.add(cnt);
        	}
        }
        answer.add(0);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String [] args) {
		int [] a = {1,2,3,2,3,1};
		System.out.println(Arrays.toString(solution(a)));
	}
}
