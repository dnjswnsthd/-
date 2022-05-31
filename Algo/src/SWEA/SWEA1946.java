package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA1946 간단한 압축풀기
 * 22.05.31
 */
public class SWEA1946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			char [] alpha = new char[n];
			int [] num = new int[n];
			for(int i = 0; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				alpha[i] = st.nextToken().charAt(0);
				num[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + t);
			int tmp = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < num[i]; j++) {
					System.out.print(alpha[i]);
					tmp++;
					if(tmp == 10) {
						System.out.println();
						tmp = 0;
					}
				}
			}
			System.out.println();
		}
	}
}
