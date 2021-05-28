#include <iostream>
#include <algorithm>
#define MAX 101
 
using namespace std;
 
int N;    // N: 주문의 수
int M, K;    // M: 치즈버거 개수, K: 감자튀김 개수
int cheese[MAX];    // 치즈버거 주문
int ff[MAX];        // 감자튀김 주문
int dp[MAX][301][301];
 
int knapsack(int pos, int c, int f)    
{
    if (pos == N) return 0;    // 주문할게 없으면 0을 반환
    if (dp[pos][c][f] >= 0) return dp[pos][c][f];    // 이미 계산된 값
    int ret = 0;
    if (cheese[pos] <= c && ff[pos] <= f) {
        ret = knapsack(pos + 1, c - cheese[pos], f - ff[pos]) + 1;    // 주문을 처리할 수 있음
    }
    ret = max(ret, knapsack(pos + 1, c, f));    
    return dp[pos][c][f] = ret;    // dp값을 갱신함과 동시에 결과값 반환
}
 
int main(void)
{
    cin >> N >> M >> K;    // N: 주문의 수, M: 치즈버거 개수, K: 감자튀김 개수
    
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j <= M; ++j) {
            for (int k = 0; k <= K; ++k) {
                dp[i][j][k] = -1;    // dp값 초기화
            }
        }
    }
    for (int i = 0; i < N; ++i) {
        cin >> cheese[i] >> ff[i];    // 주문
    }
 
    cout << knapsack(0, M, K) << "\n";
 
    return 0;
}
