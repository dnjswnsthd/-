package SWEA;
/*
 * 1284 수도 요금 경쟁
 * 22.05.28
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1284 {
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int companyApay, companyBpay = 0;
			companyApay = p * w;
			companyBpay = (r >= w) ? q : q + ((w - r) * s);  
			int res = (companyApay > companyBpay) ? companyBpay : companyApay;
			System.out.println("#" + t + " " + res);
		}
	}
}
