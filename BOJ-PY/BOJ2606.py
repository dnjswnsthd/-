import sys
n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())
connect = [[0 for _ in range(n + 1)] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    connect[a][b] = 1
    connect[b][a] = 1

def bfs(connect, tmp):
    queue = [tmp]
    visited = []

    while queue:
        chk = queue.pop(0)
        visited.append(chk)

        for i in range(len(connect)):
            if connect[chk][i] and i not in visited and i not in queue:
                queue.append(i)
    return len(visited) - 1
print(bfs(connect, 1))
