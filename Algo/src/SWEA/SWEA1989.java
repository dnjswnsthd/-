package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * SWEA 1989 초심자의 회문 검사
 * 22.05.16
 */
public class SWEA1989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++) {
            String str = br.readLine();
            int nDiv = str.length() / 2;
            int cnt = 0;
            for(int j = 0; j < nDiv; j++) {
                if (str.charAt(j) ==  str.charAt(str.length() - j - 1)) {
                    cnt++;
                }else break;
            }
            if(cnt == nDiv) {
                System.out.println("#" + i + " " + 1);
            }else {
                System.out.println("#" + i + " " + 0);
            }
        }
    }
}