package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14003 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int input[] = new int[n + 1];
        int check[] = new int[n + 1];
        for(int i = 1 ; i <= n; i++) input[i] = Integer.parseInt(st.nextToken());
        list.add(Integer.MIN_VALUE);
        for(int i = 1 ; i <= n; i++){
            int num = input[i];
            int l = 1;
            int r = list.size() - 1;
            if(num > list.get(list.size() - 1)) {
                list.add(num);
                check[i] = list.size() - 1;
            }
            else{
                while(l < r){
                    int m = (l + r) >> 1;

                    if(list.get(m) >= num) r = m;
                    else l = m + 1;
                }
                list.set(r, num);
                check[i] = r;
            }
        }
        sb.append(list.size() - 1 + "\n");
        Stack<Integer> stack = new Stack();
        int tmp = list.size() - 1;
        for(int i = n; i > 0; i--){
            if(check[i] == tmp){
            	tmp--;
                stack.push(input[i]);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}