package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class SWEA2383 {
    static int P,S;
    static int ans;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();
        for(int tc = 1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> PR= new ArrayList<Integer>();
            ArrayList<Integer> PC= new ArrayList<Integer>();
            ArrayList<Integer> SR= new ArrayList<Integer>();
            ArrayList<Integer> SC= new ArrayList<Integer>();    
            ArrayList<Integer> SL = new ArrayList<Integer>();
            int[][] arr =new int[N][N];
            for(int i =0; i< N ; i++) {
                StringTokenizer st =new StringTokenizer(br.readLine());
                for(int j =0; j<N ;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    switch(arr[i][j]) {
                    case 0:
                        break;
                    case 1:
                        PC.add(i);
                        PR.add(j);
                        break;
                    default : 
                        SC.add(i);
                        SR.add(j);
                        SL.add(arr[i][j]);
                    }
                }
            } 
            P = PC.size(); 
            S = SC.size(); 
            ans = Integer.MAX_VALUE;
            check(new int[P],0,PC,PR,SC,SR,SL);
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }
    private static void check(int[] tmp, int p, ArrayList<Integer> PC, ArrayList<Integer> PR, ArrayList<Integer> SC,
            ArrayList<Integer> SR, ArrayList<Integer> SL) {
        if(p==P) {
            int time =0; 
            for(int s =0; s<S;s++) { 
                ArrayList<Integer> or = new ArrayList<Integer>();
                for(int i =0; i< P; i++) {
                    if(tmp[i]==s) {
                        or.add(Math.abs(PR.get(i)-SR.get(s))+ Math.abs(PC.get(i)-SC.get(s)));
                    }
                }
                Collections.sort(or);
                int t =0;
                int out = SL.get(s);
                int size = or.size();
                for( int i = 3; i<size; i++) {
                    if(or.get(i)-or.get(i-3)<out) {
                        or.set(i, out+or.get(i-3));
                    }
                }
                time = (size>0 && or.get(size-1)+out+1>time)?or.get(size-1)+out+1:time;
            }
            ans = time<ans?time:ans;
            return;
        }
        for(int i =0; i< S;i++) {
            tmp[p] = i;
            check(tmp, p+1, PC,PR,SC,SR,SL);
        }   
    }
}