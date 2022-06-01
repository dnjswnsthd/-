package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 1206 [S/W 문제해결 기본] 1일차 - View D3
 * 22.06.01
 */
public class SWEA1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			int [] numArr = new int [n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			loop:for(int i = 2; i < n - 2; i++) {
				int min = Integer.MAX_VALUE;
				for(int j = -2; j <= 2; j++) {
					if(j==0) continue; // 본인 제외
					if(numArr[i+j] >= numArr[i]) { // 조망권이 없다면 Skip
						continue loop;
					}else { // 조망권이 있는 건물의 가구수를 구함
						min = Math.min(min, numArr[i] - numArr[i+j]);
					}
				}
				cnt += min;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
