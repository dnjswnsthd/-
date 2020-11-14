from collections import deque
from itertools import permutations
import sys, copy

input = sys.stdin.readline

def bfs(x, y, z):
    q.append([x, y, z])
    check.append([x, y, z])
    while q:
        k = q.popleft()
        if k[0] == 0:
            ans[k[2]] = 1
        for i in range(len(t)):
            nfrom = t[i][0]
            nto = t[i][1]
            nk = copy.deepcopy(k)
            if k[nfrom] + k[nto] > limit[nto]:
                nk[nfrom] = k[nfrom] + k[nto] - limit[nto]
                nk[nto] = limit[nto]
            else:
                nk[nfrom] = 0
                nk[nto] = k[nfrom] + k[nto]
            if nk not in check:
                check.append(nk)
                q.append(nk)


a, b, c = map(int, input().split())
q, check, limit = deque(), [], [a, b, c]
ans = [0 for _ in range(c+1)]
t = list(permutations([0, 1, 2], 2))

bfs(0, 0, c)

for i in range(c+1):
    if ans[i] == 1:
        print(i, end=' ')
        
