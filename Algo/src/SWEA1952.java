import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SWEA1952 {
    static int [] pay;
    static int [] plan;
    static int tc, res;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; ++t) {
            pay = new int[4];
            plan = new int[13];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 4 ; ++i) 
                pay[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i < 13 ; ++i) 
                plan[i] = Integer.parseInt(st.nextToken());
            res = pay[3];
            dfs(1, 0);
            System.out.println("#" + t + " " + res);
        }
    }
    private static void dfs(int m, int sum) {
        if(m == 13) {
            res = res > sum ? sum : res;
            return;
        }
        // �̿����� ���� ���� ���� X
        if(plan[m] == 0) dfs(m + 1, sum);
        // �̿� Ƚ���� 1�̻��� �� 1�� �̿������ ��� ���� 
        if(plan[m] > 0) dfs(m + 1, sum + plan[m] * pay[0]);
        // 1�� ������ ä���� ��
        dfs(m + 1, sum + pay[1]);
        // 3�� ���� ���� (10������ ���� ����)
        if(m <= 10) dfs(m + 3, sum + pay[2]);
    }
}