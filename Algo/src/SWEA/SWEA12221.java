package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 구구단2
 * 22.06.18
 */
public class SWEA12221 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a >= 10 || b >= 10) {
				System.out.println("#" + test_case + " " + -1);
			} else {
				System.out.println("#" + test_case + " " + a * b);
			}
		}
	}

}
