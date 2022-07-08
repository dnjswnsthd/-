package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA10033 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			char[] cards = br.readLine().toCharArray();
			long answer = 0;
			int prevB = 0;

			for (int i = 0; i < cards.length; i++) {
				if (cards[i] == 'W') {
					answer += (i - prevB);
					prevB++;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
