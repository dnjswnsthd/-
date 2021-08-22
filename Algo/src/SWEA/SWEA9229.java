package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class SWEA9229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc, n, m;
        List<Integer> list;
        int[] arr;
        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            String [] data = br.readLine().split(" ");
            n = Integer.parseInt(data[0]);
            m = Integer.parseInt(data[1]);
            arr = new int[n];
            String[] weight = br.readLine().split(" "); 
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(weight[j]);
            }
            list = weight_chk(n, m, arr); 
            Collections.sort(list, Collections.reverseOrder());
            if(list.size() == 0) {
                System.out.print("#" + i + " " + -1 +"\n");
            } else {
                System.out.print("#" + i + " " + list.get(0) +"\n");
            }   
        }
        br.close();
    }    
    static List<Integer> weight_chk(int n, int m, int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int j = n - 1; j >= 0; j--) {
            if (arr[j] < m) {
                for (int z = j - 1; z >= 0; z--) {
                    if (arr[j] + arr[z] <= m) {
                        list.add(arr[j] + arr[z]);
                    }
                }
            }
         }   
        return list;
    }
}