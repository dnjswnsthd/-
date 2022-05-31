package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA1940 가랏! RC카!
 * 22.05.31
 */
public class SWEA1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int speed = 0;
			int distance = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int func =  Integer.parseInt(st.nextToken());
				if(func == 0) {
					distance += speed;
				}else if(func == 1) {
					int change = Integer.parseInt(st.nextToken());
					speed += change;
					distance += speed;
				}else if(func == 2) {
					int change = Integer.parseInt(st.nextToken());
					if(speed < change) {
						speed = 0;
					}else {
						speed -= change;
						distance += speed;
					}
				}
			}
			System.out.println("#" + t + " " + distance);
		}
	}
}
