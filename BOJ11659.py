import sys
n, m = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))
sumd = [0 for _ in range(n)]

for i in range(n):
    if i == 0:
        sumd[i] = data[i]
    else:
        sumd[i] = data[i] + sumd[i-1]

for _ in range(m):
    i, j = map(int, sys.stdin.readline().rstrip().split())
    if i == 1:
        print(sumd[j-1])
    else:
        print(sumd[j-1] - sumd[i-2])
    
