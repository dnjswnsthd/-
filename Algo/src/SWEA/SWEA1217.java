package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 1217. [S/W 문제해결 기본] 4일차 - 거듭 제곱
 * 22.06.05
 */
public class SWEA1217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			System.out.println("#" + t + " " + (int) Math.pow(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
		}
	}
}
