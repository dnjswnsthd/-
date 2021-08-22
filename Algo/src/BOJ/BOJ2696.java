package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class BOJ2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(((N + 1) / 2) + "\n");
            ArrayList<Integer> a = new ArrayList<>();
            int cnt = 0; // 줄 간격 띄우기 위한 용도
            for (int i = 0; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int x = Integer.parseInt(st.nextToken());
                a.add(x);
                Collections.sort(a);
                if (i % 2 == 0) {
                    if (cnt == 9 || i == N - 1) {
                        sb.append(a.get(i / 2) + "\n");
                        cnt = 0;
                    } else {
                        sb.append(a.get(i / 2) + " ");
                    }
                    cnt++;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
}
