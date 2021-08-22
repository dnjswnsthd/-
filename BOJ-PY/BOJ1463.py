import sys
n = int(sys.stdin.readline().rstrip())

res = [0 for _ in range(n+1)]

for i in range(1, n+1):
    if i == 1:
        res[i] = 0
        continue
    res[i] = res[i-1] + 1
    if i % 3 == 0 and res[i//3] + 1 < res[i]:
        res[i] = res[i//3] + 1
    if i % 2 == 0 and res[i//2] + 1 < res[i]:
        res[i] = res[i//2] + 1
print(res[n])
