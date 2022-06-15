package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * SWEA.1222. [S/W 문제해결 기본] 6일차 - 계산기1
 * 22.06.13
 */
public class SWEA1222 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			int sum = 0;
			String s = br.readLine();
			for(int i = 1; i <= len; i++) {
				if(i % 2 == 1) sum += s.charAt(i-1) - '0';
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
