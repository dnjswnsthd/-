package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * SWEA 1215. [S/W 문제해결 기본] 3일차 - 회문1
 * 22.06.03
 */
public class SWEA1215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			char[][] wordMap = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String s = br.readLine();
				for (int j = 0; j < 8; j++) {
					wordMap[i][j] = s.charAt(j);
				}
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - n; j++) {
					int chk = 0;
					for (int k = 0; k < n / 2; k++) {
						if (wordMap[i][j + k] == wordMap[i][j + n - k - 1]) chk++;						
					}
					if (chk == n / 2) cnt++;
				}
			}
			for(int i = 0; i <= 8 - n; i++) {
				for(int j = 0; j < 8; j++) {
					int chk = 0;
					for(int k = 0; k < n / 2; k++) {
						if(wordMap[i+k][j] == wordMap[i+n-k-1][j]) chk++;
					}
					if (chk == n / 2) cnt++;
				}
			}
			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
}
