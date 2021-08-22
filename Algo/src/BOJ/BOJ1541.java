package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split("\\-");
		int min = 0;
		for(int i = 0; i < str.length; i++) {
			int calc_res = calc(str[i]);
			if(i == 0) calc_res *= -1;
			min -= calc_res;
		}
		System.out.println(min);
	}

	private static int calc(String str) {
		String [] tmp = str.split("\\+");
		int res = 0;
		for(String i : tmp) {
			res += Integer.parseInt(i);
		}
		return res;
	}
	
}
