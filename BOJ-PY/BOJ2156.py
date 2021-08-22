import sys
n = int(sys.stdin.readline().rstrip())
data = [0]
for i in range(n):
    d = int(sys.stdin.readline().rstrip())
    data.append(d)
    
dp = [0, data[1]]

if n > 1:
    dp.append(data[1] + data[2])
for i in range(3, n+1):
    dp.append(max(dp[i-1], dp[i-3] + data[i-1] + data[i], dp[i-2] + data[i]))
print(dp[n])
