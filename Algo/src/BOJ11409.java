import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
 
class BOJ11409{
    final int INF = 987654321;
    int[][] cap,flow,cost;
    int n,m,MAX,maxCost,maxNum;
 
    Scanner sc = new Scanner(System.in);
    void solve(){
        n = sc.nextInt();
        m = sc.nextInt();
        MAX = 2+n+m;
        cap = new int[MAX][MAX];
        flow = new int[MAX][MAX];
        cost = new int[MAX][MAX];
        for(int i=0;i<n;i++)
            cap[0][2+i]=1;
        for(int i=0;i<m;i++)
            cap[2+n+i][1]=1;
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            for(int j=0;j<num;j++){
                int a = sc.nextInt();
                int c = sc.nextInt();
                a--;
                cap[2+i][2+n+a]=1;
                cost[2+i][2+n+a]=-c;
                cost[2+n+a][2+i]=+c;
            }
        }
        sol(0,1);
        System.out.println(maxNum+"\n"+maxCost);
 
    }
    void sol(int src,int sink){
        LinkedList<Integer> q = new LinkedList<Integer>();
        int[] parent = new int[MAX];
        int[] dist = new int[MAX];
        int[] chk = new int[MAX];
        while(true){
            Arrays.fill(parent,-1);
            Arrays.fill(dist, INF);
            Arrays.fill(chk,0);
            parent[src]=src;
            dist[src]=0;
            q.add(src);
            while(!q.isEmpty()){
                int here = q.poll();
                chk[here]=0;
                for(int i=0;i<MAX;i++){
                    if(cap[here][i]-flow[here][i]>0){
                        if(dist[i]>dist[here]+cost[here][i]){
                            dist[i]=dist[here]+cost[here][i];
                            parent[i]=here;
                            if(chk[i]!=1) q.add(i);
                            chk[i]=1;
                        }
                    }
                }
            }
            if(parent[sink]==-1) break;
            for(int p=sink;p!=src;p=parent[p]){
                flow[parent[p]][p] += 1;
                flow[p][parent[p]] -= 1;
            }
            maxNum +=1;
            maxCost += dist[sink]*-1;
        }
    }
    public static void main(String[] args) {
        new BOJ11409().solve();
    }
}