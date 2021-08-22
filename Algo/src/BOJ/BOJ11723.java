package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class mySet {
    ArrayList<Integer> S;
    mySet(){
        S = new ArrayList<>();
    }
    public void add(int x){
        if(!S.isEmpty()){
            for(int num : S){
                if(num == x)
                    return;
            }
            S.add(x);
        }else
            S.add(x);
    }
    public void remove(int x){
        if(!S.isEmpty()){
            for(int num : S){
                if(num == x) {
                    S.remove((Integer)x);
                    return;
                }
            }
        }
    }
    public int check(int x){
        if(!S.isEmpty()){
            for(int num : S){
                if(num == x)
                    return 1;
            }
        }
        return 0;
    }
    public void toggle(int x){
        if(!S.isEmpty()){
            for(int num : S){
                if(num == x) {
                    S.remove((Integer)x);
                    return;
                }
            }
        }
        S.add(x);
    }
    public void all(){
        S.clear();
        for(int i=1; i<=20; i++)
            S.add(i);
    }
    public void empty(){
        S.clear();
    }
}

public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        mySet S = new mySet();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num;
            switch(st.nextToken()){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    S.add(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    bw.write(S.check(num)+"\n");
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    S.remove(num);
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    S.toggle(num);
                    break;
                case "all":
                    S.all();
                    break;
                case "empty":
                    S.empty();
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}