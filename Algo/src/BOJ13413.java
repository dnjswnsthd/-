import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13413 {
	static int white, black;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		String start, end;
		for(int i = 0; i < tc; i++) {
			white = black = 0;
			Integer.parseInt(br.readLine());
			start = br.readLine();
			end = br.readLine();
			System.out.println(find(start, end));
		}
	}
	private static int find(String start, String end) {
		int i, len = start.length(), cnt = 0;
		char start_c, end_c;
		for(i = 0; i < len; i++) {
			start_c = start.charAt(i);
			end_c = end.charAt(i);
			if(start_c != end_c) {
				if(start_c == 'W') white++;
				else black++;
			}
		}
		cnt += (Math.min(white, black) + Math.abs(white-black));
		return cnt;
	}
}