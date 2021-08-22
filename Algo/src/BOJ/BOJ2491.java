package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] map = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 1;
		int max = 1;
		for (int i = 1; i < n; i++) {
			if(map[i-1] <= map[i]) cnt++;
			else cnt = 1;
			if(cnt > max)max = cnt;
		}
		cnt = 1;
		for (int i = 1; i < n; i++) {
			if(map[i-1] >= map[i]) cnt++;
			else cnt = 1;
			if(cnt > max)max = cnt;
		}
		System.out.println(max);
	}
}