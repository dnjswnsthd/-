package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 4408. 자기 방으로 돌아가기
 * 22.06.10
 * 
 */
public class SWEA4408 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int res = 0;
			int [] rooms = new int[201];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if(start % 2 == 1) start++;
				if(end % 2 == 1) end++;
				if(start > end) {
					int tmp = start;
					start = end;
					end = tmp;
				}
				for(int j = start/2; j <= end/2; j++) {
					rooms[j]++;
				}
			}
			for(int i = 1; i < rooms.length; i++) {
				res = Math.max(res, rooms[i]);
			}
			System.out.println("#" + t + " " + res);
		}
	}
}
