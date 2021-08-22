package SWEA;

import java.io.IOException;
import java.util.Scanner;
 
public class SWEA2007 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            String str = sc.next();
            int res = 0;
            for(int j = 1; j <= str.length(); j++) {
                String tmp = str.substring(0,j);
                boolean different = false;
                for(int k = 0; k + tmp.length() < str.length(); k += tmp.length()) {
                    String cmp = str.substring(k, k + tmp.length());
                    if(!cmp.equals(tmp)) {
                        different = true;
                        break;
                    }
                }
                if(different == false) {
                    res = j;
                    break;
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
        sc.close();
    }
}