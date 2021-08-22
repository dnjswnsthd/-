from collections import deque
import sys

input = sys.stdin.readline

def bfs():
    q.append(0)
    c[0] = 1
    while q:
        x = q.popleft()
        if x == n-1:
            print(c[x])
            return
        for nx in a[x]:
            if not c[nx]:
                if nx >= n:
                    c[nx] = c[x]
                    q.append(nx)
                else:
                    c[nx] = c[x] + 1
                    q.append(nx)
    print(-1)

n, k, m = map(int, input().split())
a = [[] for _ in range(n+m)]
c = [0 for _ in range(n+m)]
q = deque()

for i in range(m):
    row = list(map(int, input().split()))
    for j in range(k):
        a[row[j]-1].append(n+i)
        a[n+i].append(row[j]-1)

bfs()
