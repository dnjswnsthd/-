package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		Time [] time = new Time[tc];
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[t] = new Time(start, end);
		}
		Arrays.sort(time);
		int cnt = 0;
		int tmp = -1;
		for(int i = 0; i < tc; i++) {
			if(time[i].start >= tmp) {
				tmp = time[i].end;
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}
	static class Time implements Comparable<Time>{
		int start, end;
		public Time (int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time o) {
			if(end == o.end) {
				return Integer.compare(start, o.end);
			}else {
				return Integer.compare(end,  o.end);
			} 
		}
	}
}
