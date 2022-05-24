package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2005 Pascal 삼각형
 * 22.05.24
 */
public class SWEA2005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int tc = Integer.parseInt(br.readLine());
		for(int i = 1; i <= tc; i++) {
			int len = Integer.parseInt(br.readLine());
			int [][] pascal = new int[len][len];
			pascal[0][0] = 1;
			for(int j = 1; j < len; j++) {
				pascal[j][0] = 1;
				pascal[j][j] = 1;
				for(int k = 1; k < j; k++) {
					pascal[j][k] = pascal[j-1][k-1] + pascal[j-1][k];
				}
			}
			System.out.println("#" + i);
			for(int j = 0; j < len; j++) {
				for(int k = 0; k <= j; k++) {
					System.out.print(pascal[j][k] + " ");
				}
				System.out.println();
			}
		}
	}
}
