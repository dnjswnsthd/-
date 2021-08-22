package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class SWEA1289 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int cnt;
        char bit;
        for (int t = 1; t <= tc; t++) {
            String s = br.readLine();
            bit = '0';
            cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if(bit != s.charAt(i)) {
                    cnt++;
                    bit = s.charAt(i);
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}