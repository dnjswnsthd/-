from collections import deque
import sys
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(a, b):
    q.append([a, b])
    visited[a][b] = 1
    vq, oq = [], []
    while q:
        a, b = q.popleft()
        if data[a][b] == 'v':
            vq.append([a,b])
        elif data[a][b] == 'o':
            oq.append([a,b])
        for i in range(4):
            nx = dx[i] + a
            ny = dy[i] + b
            if 0 <= nx < n and 0 <= ny < m:
                if data[nx][ny] != '#' and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    q.append([nx, ny])
    if len(vq) >= len(oq):
        for i in oq:
            data[i[0]][i[1]] = '.'
    else:
        for i in vq:
            data[i[0]][i[1]] = '.'

n, m = map(int, sys.stdin.readline().rstrip().split())
data = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]
q = deque()

for i in range(n):
    for j in range(m):
        if data[i][j] != '#' and visited[i][j] == 0:
            bfs(i, j)
cnt_o, cnt_v = 0, 0
for i in range(n):
    for j in range(m):
        if data[i][j] =='o':
            cnt_o += 1
        elif data[i][j] == 'v':
            cnt_v += 1
print(cnt_o, cnt_v)
