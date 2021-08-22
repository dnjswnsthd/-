import sys

n = int(sys.stdin.readline().rstrip())
da = []
db = []
res = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    da.append(a)
    db.append(b)
    res.append(b)
res.append(0)
for i in range(n -1, -1, -1):
    if da[i] + i > n:
        res[i] = res[i + 1]
    else:
        res[i] = max(res[i + 1], db[i] + res[i + da[i]])
print(res[0])

