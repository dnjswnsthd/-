import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w  = Integer.parseInt(st.nextToken());
		int h =  Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x =  Integer.parseInt(st.nextToken());
		int y =  Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		
		boolean max_w = (x + time) / w % 2 == 1;
		boolean max_h = (y + time) / h % 2 == 1;
		int res_x = 0;
		int res_y = 0;
		if(max_w) res_x = w - (x + time) % w;
		else res_x = (x + time) % w;
		if(max_h) res_y = h - (y + time) % h;
		else res_y = (y + time) % h;
		System.out.println(res_x + " " +res_y);
	}
}