package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class BOJ1019 {
    static int N;
    static int start,end;
    static int multi=1;
    static int arr[] = new int[10];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = 1;
        end = N;
        while(start<=end) {
            
            while(start%10!=0 && start<=end) {
                solve(start);
                start++;
            }
            
            if(start>end)
                break;
            while(end%10!=9 && start<=end) {
                solve(end);
                end--;
            }
            start/=10;
            end/=10;
            
            for(int i=0; i<10; i++) {
                arr[i] += (end-start+1)*multi;
            }
            multi*=10;
        }
        for(int i=0; i<10; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    private static void solve(int s) {
        // TODO Auto-generated method stub
        while(s>0) {
            arr[s%10]+=multi;
            s/=10;
        }
    }
}