package Programmers_kit;

import java.util.HashSet;
import java.util.Iterator;

// 프로그래머스 코딩테스트 연습 dp N으로 표현
public class Pro_dp_1 {
	static HashSet<Integer> [] dp = new HashSet[9]; // 1부터 최대 8개 N을 이용 할 수 있도록 배열크기 설정
	public static int solution(int N, int number) {
		if(N == number) return 1;
		String str = String.valueOf(N);
		for(int i = 0; i <= 8 ; i++) {
			dp[i] = new HashSet <Integer>();
			if(i == 1) dp[1].add(Integer.parseInt(str));
			if(i < 2) continue;
			//dp[4]NNNN
			str += String.valueOf(N);
			dp[i].add(Integer.parseInt(str));
			for(int j = 1; j < i; j++) {
				op(j, i);
				System.out.println("-----------------------");
				if(dp[i].contains(number)) {
					return i;
				}
			}
		}
		return -1;
    }
	// 각 N의 개수마다 사칙연산을 해서 배열에 저장
	public static void op(int a, int b) {
		System.out.println("a : " + a + " b : " + b);
		Iterator <Integer> list1 = dp[a].iterator();
		Iterator <Integer> list2 = dp[b - a].iterator();
		while(list1.hasNext()) {
			int num1 = list1.next();
			System.out.println("num1 : " + num1);
			while(list2.hasNext()) {
				int num2 = list2.next();
				System.out.println("num2 : " + num2);
				dp[b].add(num1 + num2);
				dp[b].add(num1 - num2);
				dp[b].add(num1 * num2);
				if(num2 != 0) dp[b].add(num1 / num2);
			}
			list2 = dp[b - a].iterator();
		}
	}
	public static void main(String [] args) {
		int a = 5;
		int b = 12;
		System.out.println(solution(a, b));
	}
}
