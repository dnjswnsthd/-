package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 1209.[S/W 문제해결 기본] 2일차 - Sum
 * 22.06.02
 */
public class SWEA1209 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			int [][] arrNum = new int [100][100];
			int rowSum = 0, colSum = 0, max = 0, crsSum = 0, reCrsSum = 0;
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				rowSum = 0;
				for(int j = 0; j < 100; j++) {
					arrNum[i][j] = Integer.parseInt(st.nextToken());
					rowSum += arrNum[i][j];
				}
				max = (rowSum > max) ? rowSum : max; 
			}
			for(int i = 0; i < 100; i++) {
				colSum = 0;
				crsSum += arrNum[i][i];
				reCrsSum += arrNum[i][99 - i];
				for(int j = 0; j < 100; j++) {
					colSum += arrNum[j][i];
				}
				max = (colSum > max) ? colSum : max; 
			}
			max = (crsSum > max) ? crsSum : max;
			max = (reCrsSum > max) ? reCrsSum : max;
			System.out.println("#" + t + " " + max);
		}
	}
}
