import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ2961 {
    static int[][] t;
    static boolean[] visited;
    static int n, min; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[2][n];
        visited = new boolean[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[0][i] = Integer.parseInt(st.nextToken());
            t[1][i] = Integer.parseInt(st.nextToken());
        }
        food(0, 1, 0);
        System.out.println(min);
    }
    private static void food(int index, int t_sour, int t_bitter) {
        if (index == n) {
            if (min > Math.abs(t_sour - t_bitter) && t_bitter != 0) {
                min = Math.abs(t_sour - t_bitter);
            }
            return;
        }
        visited[index] = true;
        food(index + 1, t_sour * t[0][index], t_bitter + t[1][index]);
        visited[index] = false;
        food(index + 1, t_sour, t_bitter);
    }
}