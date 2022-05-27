package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1961 숫자 배열 회전
 * 22.05.27
 */
public class SWEA1961 {
	public static int [][] matrixRotation(int [][] matrix){
		int [][] tmpMatrix = new int [matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				tmpMatrix[i][j] = matrix[matrix.length-j-1][i];
			}
		}
		return tmpMatrix;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int [][] matrix = new int [n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}	
			int [][] resMatrix1 = matrixRotation(matrix);
			int [][] resMatrix2 = matrixRotation(resMatrix1);
			int [][] resMatrix3 = matrixRotation(resMatrix2);
			System.out.println("#" + t);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(resMatrix1[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < n; j++) {
					System.out.print(resMatrix2[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < n; j++) {
					System.out.print(resMatrix3[i][j]);
				}
				System.out.println();
			}
		}
	}
}
