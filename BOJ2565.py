import sys
n = int(sys.stdin.readline().rstrip())
data1 = []
data2 = []
dp = [0 for i in range(n)]
for i in range(n):
    data1.append(list(map(int, sys.stdin.readline().rstrip().split())))
data1.sort(key = lambda x:x[0])
for i in range(n):
    data2.append(data1[i][1])
for i in range(n):
    for j in range(i):
        if data2[i] > data2[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
print(n - max(dp))
