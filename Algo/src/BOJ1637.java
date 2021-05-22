import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ1637 {
    public static int n;
    public static int[] arr1,arr2,arr3;
    public static int max, min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        arr2 = new int[n];
        arr3 = new int[n];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr3[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, arr3[i]);
            min = Math.min(min, arr1[i]);
        }

        binary();

    }
    private static void binary() {
        long left = min;
        long right = max;
        while(left<right){
            long mid = (left+right) / 2;

            long sum = calcSum(mid);
            if(sum % 2 == 0){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        long res = calcSum(left) - calcSum(left - 1);
        if(res % 2 == 0){
            System.out.println("NOTHING");
        }else{
            System.out.println(left + " " + res);
        }
    }

    private static long calcSum(long mid) {
        long sum = 0;
        for(int i = 0; i < n; i++){
            if(mid >= arr1[i])
                sum+= ((Math.min(mid, arr3[i]) - arr1[i]) / arr2[i]) + 1;
        }
        return sum;
    }

}