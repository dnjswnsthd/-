import sys
n = int(sys.stdin.readline().rstrip())
res = []
for i in range(n):
    res.append(list(map(int, sys.stdin.readline().split())))
res.sort(key=lambda x:(x[1], x[0]))
for i in res:
    print(i[0], i[1])
