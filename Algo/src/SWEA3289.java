import java.io.*;
import java.util.*;
  
class SWEA3289 {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=TC; test_case++) {
            sb.append("#" + test_case + " ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            parent = new int[n+1];
            for(int i=1; i<=n; i++) {
                parent[i]=i;
            }
            int m = Integer.parseInt(st.nextToken());
            for(int i=0;i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                if(x==0) {
                    union(y,z);
                } else if (x==1) {
                    if(findSet(y) == findSet(z)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if( x== y) {
            return;
        }
        parent[y] = x;
    }
      
    static int findSet(int x) {
        if(x==parent[x]) {
            return x;
        }
        parent[x] = findSet(parent[x]);
        return parent[x];
    }
}