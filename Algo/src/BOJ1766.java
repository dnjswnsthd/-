import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class BOJ1766 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ind = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
        	st  = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            ind[y]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i=1; i<=N; i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current+" ");
            for(int i=0; i<list[current].size(); i++){
                int next = list[current].get(i);
                ind[next]--;
                if(ind[next]==0){
                    q.add(next);
                }
            }
        }
    }
 
}
