import sys
sys.setrecursionlimit(10000)
n, m = map(int, sys.stdin.readline().rstrip().split())
s = [[0]*(n+1) for i in range(n + 1)]
visit = [0 for i in range(n+1)]
cnt = 0
def dfs(i):
    visit[i] = 1
    for j in range(1, n + 1):
        if s[i][j] == 1 and visit[j] == 0:
            dfs(j)

for i in range(m):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    s[a][b] = 1
    s[b][a] = 1
for i in range(1, n+1):
    if visit[i] == 0:
        dfs(i)
        cnt += 1
print(cnt)
