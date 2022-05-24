package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
/*
 * SWEA D2 1928.Base64 Decoder
 * 22.05.23
 */
public class SWEA1928 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i = 1; i <= tc; i++) {
			String str = br.readLine();
			byte[] decode = Base64.getDecoder().decode(str);
			String decodeString = new String(decode);
			System.out.println("#" + i + " " + decodeString);
		}
	}
}
