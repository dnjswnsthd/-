package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 1959 두 개의 숫자열
 * 22.05.31
 */
public class SWEA1959 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int [] arrA = new int [n];
			int [] arrB = new int [m];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			if(n > m) {
				for(int i = 0; i < arrA.length - arrB.length + 1; i++) {
					int tmp = 0;
					for(int j = 0; j < arrB.length; j++) {
						tmp += arrA[i+j] * arrB[j];
					}
					max = Math.max(max, tmp);
				}
			}else {
				for(int i = 0; i < arrB.length - arrA.length + 1; i++) {
					int tmp = 0;
					for(int j = 0; j < arrA.length; j++) {
						tmp += arrA[j] * arrB[i + j];
					}
					max = Math.max(max, tmp);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
