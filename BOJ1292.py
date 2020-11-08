import sys

data = []
n = 0
for i in range(1, 47, 1):
    n = i
    while not n == 0:
        data.append(i)
        n -= 1
n, m = map(int, sys.stdin.readline().rstrip().split())
res = 0
for i in range(n-1, m, 1):
    res += data[i]
print(res)
