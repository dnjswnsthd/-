package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11401 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long tmp = 1000000007;
		
		long arr[] = new long[n+1];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2; i <= n; i++){
			arr[i] = (arr[i - 1] * i) % tmp;
		}
		long a = arr[n];
		long b = ( arr[k] * arr[n - k] ) % tmp;
		
		long c = tmp - 2;
		long d = 1;
		while(c > 0) {
			if(c % 2 == 1) {
				d = (d * b) % tmp;
			}
			b = (b * b) % tmp;
			c /= 2;
		}
		br.close();
		System.out.println(((a % tmp) * (d % tmp)) % tmp);
	}
}
