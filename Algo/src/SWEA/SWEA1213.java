package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 1213. [S/W 문제해결 기본] 3일차 - String
 * 22.06.03
 */
public class SWEA1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			String tmp = br.readLine();
			String str = br.readLine();
			str = str.replaceAll(tmp, "#");
			int cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '#') {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
