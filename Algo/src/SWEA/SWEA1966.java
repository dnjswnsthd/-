package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * SWEA 1966 숫자를 정렬하자
 * 22.05.29
 */
public class SWEA1966 {
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int [] numArr = new int [n];
			st = new StringTokenizer(br.readLine());
			ArrayList <Integer> al = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				al.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(al);
			System.out.print("#" + t);
			for(int i = 0; i < al.size(); i++) {
				System.out.print(" " + al.get(i));
			}
			System.out.println();
		}
	}
}
