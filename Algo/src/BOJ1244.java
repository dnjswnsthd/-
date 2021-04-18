import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] data = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(sex == 1) {
				for(int j = num; j < data.length; j += num) {
					if(data[j] == 1) data[j] = 0;
					else data[j] = 1;
				}
			}else {
				if(data[num] == 1) data[num] = 0;
				else data[num] = 1;
				if(num > 1 && num < n) {
					int num_low = num;
					int num_high = num;
					while(true) {
						num_low -= 1;
						num_high += 1;
						if(num_low > 0 && num_high < data.length && data[num_low] == data[num_high]) {
							if(data[num_low] == 1) {data[num_low] = 0; data[num_high] = 0;}
							else {data[num_low] = 1; data[num_high] = 1;}
						}else {break;}
					}
				}
			}
			
		}
		for(int i = 1; i < data.length; i++) {
			System.out.print(data[i] + " ");
			if(i >= 20 && i % 20 == 0)System.out.println();
		}
	}
}
