import sys
n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
dp = [a for a in data]

for i in range(n):
    for j in range(i):
        if data[i] > data[j]:
            dp[i] = max(dp[i], dp[j] + data[i])
print(max(dp))

