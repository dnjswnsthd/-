package SWEA;

import java.io.*;
import java.util.*;
  
public class SWEA9839 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            result = -1;
            int N = Integer.parseInt(br.readLine());
            int input[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            int mul= 1;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    mul = input[i]*input[j];
                    if(isOderBy(mul) && mul > result) result = mul;
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
    private static boolean isOderBy(int mul) {
        int mod = mul%10;
        int tmp = mul/10;
        while(tmp>0) {
            if(mod -1 == tmp%10) mod = tmp%10;
            else return false;
            tmp /= 10;
        }
        return true;
    }
}