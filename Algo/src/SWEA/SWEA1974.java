package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 1974. 스토쿠 검증
 * 22.05.25 
 */

public class SWEA1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int[][] sudoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int check = 1;
			loop: for (int i = 0; i < 9; i++) {
				int[] numArrRow = new int[10];
				int[] numArrCol = new int[10];
				for (int j = 0; j < 9; j++) {
					if (numArrRow[sudoku[i][j]] == 0) {
						numArrRow[sudoku[i][j]]++;
					} else {
						check = 0;
						break loop;
					}
					if (numArrCol[sudoku[j][i]] == 0) {
						numArrCol[sudoku[j][i]]++;
					} else {
						check = 0;
						break loop;
					}
				}
			}
			loop: for (int i = 0; i < 7; i = i + 3) {
				for (int j = 0; j < 7; j = j + 3) {
					int[] block = new int[10];
					for (int k = i; k < i + 3; k++) {
						for (int l = j; l < j + 3; l++) {
							if (block[sudoku[k][l]] == 0) {
								block[sudoku[k][l]]++;
							} else {
								check = 0;
								break loop;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + check);
		}
	}
}
