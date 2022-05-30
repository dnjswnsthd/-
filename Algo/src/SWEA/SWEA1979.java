package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1979 어디에 단어가 들어갈 수 있을까
 * 22.05.30
 */
public class SWEA1979 {
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int [][] puzzle = new int [n][n];
			int res = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int cnt = 0;
				for(int j = 0; j < n; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
					if(puzzle[i][j] == 1) {
						cnt++;
						if(j == n - 1 && cnt == k) {
							res++;
						}
					}else {
						if(cnt == k) {
							res++;
						}
						cnt = 0;
					}
				}
			}
			for(int i = 0; i < n; i++) {
				int cnt = 0;
				for(int j = 0; j < n; j++) {
					if(puzzle[j][i] == 1) {
						cnt++;
						if(j == n - 1 && cnt == k) {
							res++;
						}
					}else {
						if(cnt == k) {
							res++;
						}
						cnt = 0;
					}
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}
}
