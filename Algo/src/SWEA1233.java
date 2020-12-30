import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class SWEA1233 {
    static int [] visited;
    static int [][] edge;
    static String [] node;
    static int n;
    static Stack <Integer> stack;
    static int chk;
    public static void oper(String str) {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            if(stack.size() < 2) {
                chk = 0;
                return ;
            }
            int num_1 = stack.pop();
            int num_2 = stack.pop();
            if(str.equals("+")) stack.push(num_2 + num_1);
            else if(str.equals("-")) stack.push(num_2 - num_1);
            else if(str.equals("*")) stack.push(num_2 * num_1);
            else if(str.equals("/")) {
                if(num_1 == 0) num_1 = 1;
                stack.push(num_2 / num_1);
            }
        }else stack.push(Integer.parseInt(str));    
    }
    public static void dfs(int index) {
        if(chk == 0) return;
        visited[index] = 1;
        for(int i = 1; i <= n; i++) {
            if(edge[index][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
        oper(node[index]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++) {
            n = Integer.parseInt(br.readLine());
            visited = new int[n+1];
            edge = new int[n+1][n+1];
            node = new String[n+1];
            stack = new Stack <> ();
            chk = 1;
            for(int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int tmp_1 = Integer.parseInt(st.nextToken());
                node[i] = st.nextToken();
                for(int j = 0; j < 2; j++) {
                    if(st.hasMoreTokens()) {
                        int tmp_2 = Integer.parseInt(st.nextToken());
                        edge[tmp_1][tmp_2] = 1;
                    }
                }
            }
            dfs(1);
            if(stack.size() < 1) chk = 0;
            System.out.println("#" + t + " " + chk);
        }
    }
}