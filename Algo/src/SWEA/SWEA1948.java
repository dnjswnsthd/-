package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 1948 날짜 계산기
 * 22.05.31
 */
public class SWEA1948 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int [] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			int sum = month[startMonth - 1] - startDay + 1;
			if(startMonth != endMonth) {
				sum += endDay;
			}
			for(int i = startMonth; i < endMonth - 1; i++) {
				sum += month[i];
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
