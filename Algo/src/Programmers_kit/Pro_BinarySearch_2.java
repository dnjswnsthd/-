package Programmers_kit;

import java.util.Arrays;
// 프로그래머스 코딩테스트 연습 이분탐색 징검다리
public class Pro_BinarySearch_2 {
	public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int min = 0, max = distance;
        int mid = 0;
        while(min <= max) {
        	mid = (min + max) /2;
        	int prev = 0, cnt = 0;
        	for(int i = 0; i < rocks.length; i++) {
        		if(rocks[i] - prev < mid) {
        			cnt++;
        			if(cnt > n) break;
        		}else {
        			prev = rocks[i];
        		}
        	}
        	if(cnt > n) {
        		max = mid - 1;
        	}else {
        		if(answer < mid) answer = mid;
        		min = mid + 1;
        	}
        }
        return answer;
    }
	public static void main(String [] args) {
		int a = 25;
		int [] b = {2, 14, 11, 21, 17};
		int c = 2;
		System.out.println(solution(a,b,c));
	}
}
