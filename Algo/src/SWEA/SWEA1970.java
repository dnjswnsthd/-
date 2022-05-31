package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * SWEA 1970 쉬운 거스름돈
 * 22.05.31
 */
public class SWEA1970 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println("#" + t);
			int [] money = new int [8];
			System.out.print(n / 50000 + " "); n = n % 50000;
			System.out.print(n / 10000 + " "); n = n % 10000;
			System.out.print(n / 5000 + " "); n = n % 5000;
			System.out.print(n / 1000 + " "); n = n % 1000;
			System.out.print(n / 500 + " "); n = n % 500;
			System.out.print(n / 100 + " "); n = n % 100;
			System.out.print(n / 50 + " "); n = n % 50;
			System.out.println(n / 10); n = n % 10;
		}
	}
}
