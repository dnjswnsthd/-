import sys
n = int(sys.stdin.readline().rstrip())
data = []
for i in range(n):
    data.append(int(sys.stdin.readline().rstrip()))

find = n
ans = 0
for i in range(n-1, -1, -1):
    if data[i] == find:
        find -= 1
    else:
        ans += 1
print(ans)
