package BOJ;

import java.util.*;

public class BOJ1065 {
	static int cnt = 0;
	public static void main(String argsp[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for(int i = 1; i <= n; i++) {
			if(i < 100)
				cnt++;
			else if(i == 1000)
				break;
			else
				count(i);
		}
		System.out.println(cnt);
	}
	static void count(int i) {
		int temp = i;
		int st = temp / 100;
		temp %= 100;
		int nd = temp /10;
		temp %= 10;
		int rd = temp;
		if(st - nd == nd - rd)
			cnt++;
	}
}