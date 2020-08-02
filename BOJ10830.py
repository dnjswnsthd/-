import sys

def mat_mul(a,b):
    res = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                res[i][j] += a[i][k] * b[k][j]

    for i in range(n):
        for j in range(n):
            res[i][j] %= 1000
    return res

n, b = map(int, sys.stdin.readline().rstrip().split())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
b = bin(b)[2:]

data2 = [[1 if i == j else 0 for i in range(n)] for j in range(n)]


res = data2[:]
for i in range(len(b)):
    if b[-i-1] == '1':
        tmp = data[:]
        while i != 0:
            tmp = mat_mul(tmp, tmp)
            i -= 1
        res = mat_mul(res, tmp)

for i in res:
    print(*i)
