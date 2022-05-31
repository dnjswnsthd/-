package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * SWEA1285 아름이의 돌 던지기
 * 22.05.31
 */
public class SWEA1285 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList <Integer> al = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				al.add(Math.abs(Integer.parseInt(st.nextToken())));
			}
			Collections.sort(al);
			int min = al.get(0);
			int cnt = 0;
			for(int i = 0; i < al.size(); i++) {
				if(al.get(i) == min) {
					cnt++;
				}else break;
			}
			System.out.println("#" + t + " " + min + " " + cnt);
		}
	}
}
