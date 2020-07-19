import sys
from itertools import combinations

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
dp = [0 for i in range(n)]

for i in range(n):
    for j in range(i):
        if data[i] > data[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
print(max(dp))
