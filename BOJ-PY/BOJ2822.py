import sys

data = []
for i in range(8):
    n = int(sys.stdin.readline().rstrip())
    data.append(n)

res = []
res_sum = 0

for _ in range(5):
    m = data.index(max(data))
    res.append(m+1)
    res_sum += data[m]
    data[m] =0

print(res_sum)
res.sort()
for i in range(5):
    print(res[i], end=" ")
