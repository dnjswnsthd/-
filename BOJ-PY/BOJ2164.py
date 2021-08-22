import sys
from collections import deque
n = int(sys.stdin.readline().rstrip())
que = deque([])
tmp = 0
for i in range(1, n + 1):
    que.append(i)
for i in range(n-1):
    que.popleft()
    tmp = que[0]
    que.popleft()
    que.append(tmp)
    
print(que[0])
