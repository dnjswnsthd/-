package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA6959 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String s = br.readLine();
			int len = s.length();
			int sum = 0;
			int res = 0;
			for (int i = 0; i < len; i++) {
				sum += s.charAt(i) - '0';
				res++;
				if (sum >= 10) {
					sum = sum / 10 + sum % 10;
					res++;
				}
			}
			sb.append("#" + t + " ");
			if (res % 2 == 0) sb.append("A" + "\n");
			else sb.append("B" + "\n");
		}
		System.out.println(sb);
	}
}
