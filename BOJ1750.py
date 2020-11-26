from math import gcd
import sys
MIS = lambda: map(int, sys.stdin.readline().rstrip().split())
MOD = 10000003

n = int(sys.stdin.readline().rstrip())
dp = [1] + [0]*100000
for _ in range(n):
    x = int(input())
    new = [0]*100001
    new[x]+= dp[0]; new[0]+= dp[0]
    for y in range(1, 100001):
        if dp[y]: new[y]+= dp[y]; new[gcd(x,y)]+= dp[y]
    dp = [x%MOD for x in new]
print(dp[1])
