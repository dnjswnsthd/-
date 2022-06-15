package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * SWEA 1486 장훈이의 높은 선반
 * 22.06.13
 * 부분집합
 */
public class SEWEA1486 {
	static int [] people;
	static int n, b, res;
	static boolean [] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			people = new int [n];
			isSelected = new boolean [n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}
			res = Integer.MAX_VALUE;
			powerset(0);
			System.out.println("#" + t + " " + res);
		}
	}
	public static void powerset(int cnt) {
		if (cnt == n) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				if(isSelected[i]) {
					sum += people[i];
				}
			}
			if(sum >= b) {
				sum -= b;
				res = (res > sum) ? sum : res;
			}
			return;
		}
		isSelected[cnt] = true;
		powerset(cnt + 1);
		isSelected[cnt] = false;
		powerset(cnt + 1);
	}
}
