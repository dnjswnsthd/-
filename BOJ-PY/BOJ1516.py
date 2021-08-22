import sys
from collections import deque
n = int(sys.stdin.readline().rstrip())
data = [[] for i in range(n)]
t = [0] * n
index = [0] * n
for i in range(n):
    l = list(map(int, sys.stdin.readline().rstrip().split()))
    t[i] = l[0]
    for j in range(1, len(l)-1):
        y = i
        x = l[j] -1
        data[x].append(y)
        index[y] += 1
q = deque()
res = [0] * n
for i in range(n):
    if index[i] == 0:
        res[i] = t[i]
        q.append(i)

while q:
    x = q.popleft()
    for y in data[x]:
        index[y] -= 1
        res[y] = max(res[y], t[y] + res[x])
        if index[y] == 0:
            q.append(y)
for i in res: print(i)
