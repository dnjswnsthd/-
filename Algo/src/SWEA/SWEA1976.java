package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA1976 사각 덧셈
 * 22.05.31
 */
public class SWEA1976 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int startHour = Integer.parseInt(st.nextToken());
			int startMinute = Integer.parseInt(st.nextToken());
			int endHour = Integer.parseInt(st.nextToken());
			int endMinute = Integer.parseInt(st.nextToken());
			int hour = 0;
			int minute = startMinute + endMinute;
			if(minute >= 60) {hour += 1; minute -= 60;}
			hour += startHour + endHour;
			if(hour >= 13) hour -= 12;
			System.out.println("#" + t + " " + hour + " " + minute);
		}
	}
}
