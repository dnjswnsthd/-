import sys
import heapq
r = sys.stdin.readline
INF = 1e9

def dijkstra(n, s, e, edg):
    q = []
    dist = [INF] * n
    dist[s-1] = 0
    heapq.heappush(q, [s-1, 0])

    while q:
        pos, cost = heapq.heappop(q)

        for p, c in edg[pos]:
            c += cost
            if c < dist[p]:
                dist[p] = c
                heapq.heappush(q, [p, c])
    return dist[e-1]


N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
edges = [[] for _ in range(N)]
for i in range(M):
    u, v, w = list(map(int, sys.stdin.readline().rstrip().split()))
    edges[u-1].append([v-1, w])

st, end = map(int, sys.stdin.readline().rstrip().split())

print(dijkstra(N, st, end, edges))
