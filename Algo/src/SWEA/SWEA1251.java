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
            // x��ǥ
            for(int i=0; i<n; i++)
                island[i] = new Pos(Integer.parseInt(temp[i]), 0, 0);
            // y��ǥ
            temp = br.readLine().split(" ");
            for(int i=0; i<n; i++)
                island[i].y = Integer.parseInt(temp[i]);
            // ȯ�� �δ� ����
            E = Double.parseDouble(br.readLine());
            ArrayList<Pos> weights = new ArrayList<>();
            // ��� ����� ������ weight ���ϱ�
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    weights.add(new Pos(i, j, calWeight(island[i].x, island[i].y, island[j].x, island[j].y)));
                }
            }
            // weight �������� sort
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
            // �� ���� ���� ���θ� Ȯ���� parent �迭
            parent = new int[n];
            for(int i=0; i<n; i++)
                parent[i] = i;
            double ans = 0.0;
            for(int i=0; i< weights.size(); i++){
                // �θ� ���� �ʴٸ� ����Ǿ����� ���� => union
                if(!chk(weights.get(i).x, weights.get(i).y)){
                    union(weights.get(i).x, weights.get(i).y); // �����ϱ�
                    ans = ans + weights.get(i).weight; // weight ���ϱ�
                }
            }
            System.out.format("#%d %.0f\n", t, ans);
        }
        br.close();
    }
    // �θ� ������ Ȯ��
    public static boolean chk(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) return false;
        return true;
    }
    // x�� �θ� ã�� func
    public static int find(int x){
        if(parent[x] == x) return x;
        else
            return parent[x] = find(parent[x]);
    }
    // �θ� �ٸ��ٸ� �������ִ� func
    public static void union(int x, int y){
        // �θ� ã��
        x = find(x);
        y = find(y);
        // �θ� �ٸ��ٸ� ����Ǿ� ���� ���� ����
        if(x != y){
            parent[y] = x; //  ����
        }
    }
 
    // weight ���
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