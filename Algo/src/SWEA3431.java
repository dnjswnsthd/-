import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SWEA3431 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            String [] lux = br.readLine().split(" ");
            int l = Integer.parseInt(lux[0]);
            int u = Integer.parseInt(lux[1]);
            int x = Integer.parseInt(lux[2]);
            int tmp = 0;
            if(x < l) tmp = l-x;
            else if(x > u) tmp = -1;
            else tmp = 0;
             
            sb.append(tmp);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}