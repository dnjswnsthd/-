package Programmers_kit;

import java.util.Arrays;

// 프로그래머스 코딩테스트 연습 Greedy 단속카메라
public class Pro_Greedy_6 {
	public static int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;
        int min = Integer.MIN_VALUE;
        for(int [] r : routes) {
        	if(min < r[0]) {
        		min = r[1];
        		cnt++;
        	}
        }
        return cnt;
    }
	public static void main(String [] args) {
		int [][] a = {{-20,-15}, {-14, -5}, {-18, -13}, {-5, -3}};
		System.out.println(solution(a));
	}
}
