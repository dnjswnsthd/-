import sys
n, m = map(int, sys.stdin.readline().rstrip().split())
fri = [0] * n
dp = [0] * 21
cnt = 0
for i in range(n):
    tmp = len(sys.stdin.readline().rstrip())
    fri[i] = tmp
    if i > m:
        dp[fri[i-m-1]] -= 1
    cnt += dp[tmp]
    dp[tmp] += 1
print(cnt)
