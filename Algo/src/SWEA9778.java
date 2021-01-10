import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class SWEA9778 {
    public static void main(String[] args) throws Exception{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; ++t) {
            int n = Integer.parseInt(br.readLine());
            int totalCnt = 52 - n;
            int temp = 21;
            int[] cards  = {0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 16, 4};
            for(int i=0; i<n; ++i) {
                int num = Integer.parseInt(br.readLine());
                --cards[num];
                temp -= num;
            }
            String result = "GAZUA";
            if(temp <= 11){
                int cnt = 0;
                for(int i=2; i<=temp; ++i) {
                    cnt += cards[i];
                }
                 
                if(totalCnt - cnt >= cnt) {
                    result = "STOP";
                }
            }
            bw.write("#"+t+" "+result+"\n");
        }
        bw.close();
        br.close();
    }
}