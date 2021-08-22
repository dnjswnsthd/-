import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
data = []
for _ in range(n):
    data.append(sys.stdin.readline().rstrip())
res = 64
for i in range(n-7):
    for j in range(m-7):
        tmp_w = 0
        tmp_b = 0
        for k in range(i, i + 8):
            for l in range(j, j + 8):
                if k % 2 == 0 and l % 2 == 0:
                    if data[k][l] == 'B':
                        tmp_w += 1
                elif k % 2 == 1 and l % 2 == 1:
                    if data[k][l] == 'B':
                        tmp_w += 1
                elif k % 2 == 1 and l % 2 == 0:
                    if data[k][l] == 'W':
                        tmp_w += 1
                elif k % 2 == 0 and l % 2 == 1:
                    if data[k][l] == 'W':
                        tmp_w += 1
        for k in range(i, i + 8):
            for l in range(j, j + 8):
                if k % 2 == 0 and l % 2 == 0:
                    if data[k][l] == 'W':
                        tmp_b += 1
                elif k % 2 == 1 and l % 2 == 1:
                    if data[k][l] == 'W':
                        tmp_b += 1
                elif k % 2 == 1 and l % 2 == 0:
                    if data[k][l] == 'B':
                        tmp_b += 1
                elif k % 2 == 0 and l % 2 == 1:
                    if data[k][l] == 'B':
                        tmp_b += 1
        res = min(res,tmp_w, tmp_b)
print(res)
