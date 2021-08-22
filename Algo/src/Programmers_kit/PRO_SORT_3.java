package Programmers_kit;

import java.util.Arrays;
import java.util.Collections;

// 프로그래머스 코딩테스트 연습 정렬 H-index
public class PRO_SORT_3 {
	public static int solution(int[] citations) {
        int answer = 0;
        Integer [] citi = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++) {
        	citi[i] = citations[i];
        }
        Arrays.sort(citi, Collections.reverseOrder());
        int tmp = citi[0];
        while(tmp >= 0) {
        	int cnt = 0;
        	for(int i = 0; i < citi.length; i++) {
        		if(citi[i] >= tmp) {
        			cnt++;
        		}
        	}
        	if(cnt >= tmp) {
        		return tmp;
        	}
        	tmp--;
        }
        return 0;
    }
	public static void main(String [] args) {
		int [] a = {3, 0, 6, 1, 5};
		System.out.println(solution(a));
	}
}
