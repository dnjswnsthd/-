package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * SWEA 3459. 승자 예측하기
 * 22.06.12
 */
public class SWEA3459 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			long n = Long.parseLong(br.readLine());
			String res = "Alice";
			while (n > 10) {
				n = (n / 2) + 1;
				n = (n / 2) - 1;
			}
			if(n == 1 || (n >= 6 && n <= 9)) {
				res = "Bob";
			}
			System.out.println("#" + t + " " + res);
		}
	}
}
