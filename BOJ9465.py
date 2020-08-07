import sys

n = int(sys.stdin.readline().rstrip())
for i in range(n):
    data = []
    m = int(sys.stdin.readline().rstrip())
    for i in range(2):
        data.append(list(map(int, sys.stdin.readline().rstrip().split())))
    data[0][1] += data[1][0]
    data[1][1] += data[0][0]
    for i in range(2, m):
        data[0][i] += max(data[1][i-2], data[1][i-1])
        data[1][i] += max(data[0][i-2], data[0][i-1])
    res = max(data[0][m-1], data[1][m-1])
    print(res)
