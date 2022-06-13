package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * SWEA 1223. [S/W 문제해결 기본] 6일차 - 계산기2 
 * 22.06.13
 */
public class SWEA1223New {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			Stack<Integer> st = new Stack<>();
			String s = br.readLine();
			for (int i = 0; i < len; i++) {
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					st.push(s.charAt(i) - '0');
				} else if (s.charAt(i) == '+') {
					continue;
				} else if (s.charAt(i) == '*') {
					int num = st.pop();
					i++;
					num *= (s.charAt(i) - '0');
					st.push(num);
				}
			}
			int sum = 0;
			len = st.size();
			for(int i = 0; i < len; i++) {
				sum += st.pop();
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
