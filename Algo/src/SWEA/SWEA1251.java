package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class SWEA1251 {
    static int n;
    static Pos[] island;
    static double E;    
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++){
            n = Integer.parseInt(br.readLine());
            island = new Pos[n];
            String[] temp = br.readLine().split(" ");
            // x좌표
            for(int i=0; i<n; i++)
                island[i] = new Pos(Integer.parseInt(temp[i]), 0, 0);
            // y좌표
            temp = br.readLine().split(" ");
            for(int i=0; i<n; i++)
                island[i].y = Integer.parseInt(temp[i]);
            // 환경 부담 세율
            E = Double.parseDouble(br.readLine());
            ArrayList<Pos> weights = new ArrayList<>();
            // 모든 점들과 각각의 weight 구하기
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    weights.add(new Pos(i, j, calWeight(island[i].x, island[i].y, island[j].x, island[j].y)));
                }
            }
            // weight 기준으로 sort
            Collections.sort(weights, new Comparator<Pos>() {
                @Override
                public int compare(Pos p1, Pos p2){
                    if(p1.weight < p2.weight)
                        return -1;
                    else if(p1.weight > p2.weight)
                        return 1;
                    return 0;
                }
            });
            // 두 점의 연결 여부를 확인할 parent 배열
            parent = new int[n];
            for(int i=0; i<n; i++)
                parent[i] = i;
            double ans = 0.0;
            for(int i=0; i< weights.size(); i++){
                // 부모가 같지 않다면 연결되어있지 않음 => union
                if(!chk(weights.get(i).x, weights.get(i).y)){
                    union(weights.get(i).x, weights.get(i).y); // 연결하기
                    ans = ans + weights.get(i).weight; // weight 구하기
                }
            }
            System.out.format("#%d %.0f\n", t, ans);
        }
        br.close();
    }
    // 부모가 같은지 확인
    public static boolean chk(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) return false;
        return true;
    }
    // x의 부모를 찾는 func
    public static int find(int x){
        if(parent[x] == x) return x;
        else
            return parent[x] = find(parent[x]);
    }
    // 부모가 다르다면 연결해주는 func
    public static void union(int x, int y){
        // 부모 찾기
        x = find(x);
        y = find(y);
        // 부모가 다르다면 연결되어 있지 않은 상태
        if(x != y){
            parent[y] = x; //  연결
        }
    }
 
    // weight 계산
    public static double calWeight(long x, long y, long dx, long dy){        
        return E * Math.pow(Math.sqrt(Math.pow(dx-x, 2) + Math.pow(dy-y, 2)),2);
    }
}
class Pos {
    int x;
    int y;
    double weight;
 
    Pos(int x, int y, double weight){
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}