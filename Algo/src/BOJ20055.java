import java.io.*;
import java.util.*;

public class BOJ20055 {

    static int N, K;
    static int[] belt;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }
    public static int solve() {
        boolean[] robot = new boolean[N * 2];
        int zeroCnt = 0, time = 0;
        while(true) {
            time++;
            int lastIdx = 2 * N - 1;
            int lastBelt = belt[lastIdx];
            for(int i = lastIdx; i > 0; i--) belt[i] = belt[i - 1];
            belt[0] = lastBelt;
            boolean lastRobot = robot[lastIdx];
            for(int i = lastIdx; i > 0; i--) robot[i] = robot[i - 1];
            robot[0] = lastRobot;
            if(robot[N - 1]) robot[N - 1] = false;
            for(int i = N - 2; i >= 0; i--) {
                if(!robot[i]) continue;
                if(belt[i + 1] > 0 && !robot[i + 1]) {
                    robot[i + 1] = true; belt[i + 1]--; robot[i] = false;
                    if(belt[i + 1] == 0) zeroCnt++;
                }
            }
            if(!robot[0] && belt[0] > 0) {
                robot[0] = true; belt[0]--;
                if(belt[0] == 0) zeroCnt++;
            }
            if(robot[N - 1]) robot[N - 1] = false;

            if(zeroCnt >= K) return time;
        }
    }    
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        belt = new int[N * 2];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N*2; i++) belt[i] = Integer.parseInt(st.nextToken());
    }
}