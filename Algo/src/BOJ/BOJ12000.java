package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* BOJ12000 Circular Barn
* 22.05.18
*/
public class BOJ12000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int [] cows = new int[tc + 1];
        for(int i = 1; i <= tc; i++) {
        	cows[i] = Integer.parseInt(br.readLine());
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= tc; i++) {
        	int total = 0;
        	for(int j = 1; j <=tc; j++) {
        		if(j >= i) total += (j - i) * cows[j];
        		else total += (j + tc - i) * cows[j];
        	}
        	ans = Math.min(ans, total);
        }
        System.out.println(ans);
    }
}