package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * SWEA1288 새로운 불면증 치료법
 * 22.05.31
 */
public class SWEA1288 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int [] num = new int [10];
			int n = Integer.parseInt(br.readLine());
			int tmp = 1;
			while(true) {
				int res = n * tmp;
				String s = Integer.toString(res);
				for(int i = 0; i < s.length(); i++) {
					num[s.charAt(i) - '0']++;
				}
				int sum = 0;
				for(int i = 0; i < num.length; i++) {
					if(num[i] == 0) {
						break;
					}else {
						sum++;
					}
				}
				if(sum == 10) break;
				tmp++;
			}
			System.out.println("#" + t + " " + tmp * n);
		}
	}
}
