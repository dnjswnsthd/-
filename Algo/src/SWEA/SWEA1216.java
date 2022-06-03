package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * SWEA 1216. [S/W 문제해결 기본] 3일차 - 회문2
 * 22.06.03
 */
public class SWEA1216 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			int res = 0;
			char [][] wordMap = new char[100][100];
			for(int i = 0; i < 100; i++) {
				String s = br.readLine();
				for(int j = 0; j < 100; j++) {
					wordMap[i][j] = s.charAt(j);
				}
			}
			for(int l = 0; l < 100; l++) {
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j <= 100 - l; j++) {
						int chk = 0;
						for (int k = 0; k < l / 2; k++) {
							if (wordMap[i][j + k] == wordMap[i][j + l - k - 1]) chk++;						
						}
						if (chk == l / 2) res = l;
					}
				}
				for(int i = 0; i <= 100 - l; i++) {
					for(int j = 0; j <100; j++) {
						int chk = 0;
						for(int k = 0; k < l / 2; k++) {
							if(wordMap[i+k][j] == wordMap[i+l-k-1][j]) chk++;
						}
						if (chk == l / 2) res = l;
					}
				}
			}
			sb.append("#" + t + " " + res + "\n");
		}
		System.out.println(sb);
	}
}
