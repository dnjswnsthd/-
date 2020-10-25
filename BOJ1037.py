import sys
n = int(sys.stdin.readline().rstrip())

m = list(map(int, sys.stdin.readline().rstrip().split()))
m.sort()
ans = 0

for i in range(len(m)):
    ans += m[i] * m[-i-1]
print(ans//len(m))
