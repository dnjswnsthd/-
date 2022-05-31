package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1986 지그재그 숫자
 * 22.05.31
 */
public class SWEA1986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			if(n % 2 == 1) {
				System.out.println("#" + t + " " + ((n / 2) + 1));
			}else {
				System.out.println("#" + t + " -" + n / 2);
			}
		}
	}
}
