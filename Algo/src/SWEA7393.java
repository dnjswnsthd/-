import java.io.BufferedReader;
import java.io.InputStreamReader;
  
public class SWEA7393 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_000;
        final int limit = 1<<10;
        for (int testCase = 1; testCase <= TC; testCase++) {
            int N = Integer.parseInt(br.readLine()); // 수의 길이 N(1 ≤ N ≤ 100)
//          길이가 N 인 앞뒤가 1크가나 작은 (0~9 숫자가 모두 등장하는) 삐끗수(계단수)의 개수출력
            int[][][] memo = new int[N+1][10][limit];
            for (int i = 1; i < 10; i++) { // 길이가 1인 수의 개수, 0은 1자리수를 만들지 못하므로 0
                memo[1][i][1<<i] = 1;
            }
            for (int i = 2; i <= N; i++) { // 길이가 2자리~N자리까지
                for (int j = 0; j < 10; j++) { // 마지막 숫자
                    for (int k = 0; k < limit; k++) {
                        if (j == 0) {
                            memo[i][j][k|(1<<j)] = (memo[i][j][k|(1<<j)] + memo[i-1][j+1][k]) % MOD;
                        } else if (j == 9) {
                            memo[i][j][k|(1<<j)] = (memo[i][j][k|(1<<j)] +                     memo[i-1][j-1][k]) % MOD;
                        } else {
                            memo[i][j][k|(1<<j)] = (memo[i][j][k|(1<<j)] + memo[i-1][j-1][k] + memo[i-1][j+1][k]) % MOD;
                        }
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                cnt = (cnt + memo[N][i][limit-1]) % MOD;
            }
            sb.append('#').append(testCase).append(' ').append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}