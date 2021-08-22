import sys
from collections import deque
n = int(sys.stdin.readline())
head = [0] * (n+1)
head[1] = 1
tree = {}
for i in range(1, n+1):
    tree[i] = []
for _ in range(n-1):
    v1, v2 = map(int, sys.stdin.readline().split())
    tree[v1].append(v2)
    tree[v2].append(v1)
q = deque([1])
while q:
    node = q.popleft()
    for child in tree[node]:
        if not head[child]:
            head[child] = node
            q.append(child)
for h in head[2:]:
    print(h)
