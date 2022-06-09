package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * SWEA 1221. [S/W 문제해결 기본] 5일차 - GNS
 */
public class SWEA1221 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			sb.append("#" + t + "\n");
			ArrayList<Integer> al = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				String s = st.nextToken();
				if(s.equals("ZRO")) al.add(0);
				else if(s.equals("ONE")) al.add(1);
				else if(s.equals("TWO")) al.add(2);
				else if(s.equals("THR")) al.add(3);
				else if(s.equals("FOR")) al.add(4);
				else if(s.equals("FIV")) al.add(5);
				else if(s.equals("SIX")) al.add(6);
				else if(s.equals("SVN")) al.add(7);
				else if(s.equals("EGT")) al.add(8);
				else if(s.equals("NIN")) al.add(9);
			}
			Collections.sort(al);
			for(int i = 0; i < n; i++) {
				if(al.get(i) == 0) sb.append("ZRO ");
				else if(al.get(i) == 1) sb.append("ONE ");
				else if(al.get(i) == 2) sb.append("TWO ");
				else if(al.get(i) == 3) sb.append("THR ");
				else if(al.get(i) == 4) sb.append("FOR ");
				else if(al.get(i) == 5) sb.append("FIV ");
				else if(al.get(i) == 6) sb.append("SIX ");
				else if(al.get(i) == 7) sb.append("SVN ");
				else if(al.get(i) == 8) sb.append("EGT ");
				else if(al.get(i) == 9) sb.append("NIN ");
			}
			System.out.println(sb);
		}
	}
}
