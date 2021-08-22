import sys
import math
tc = int(sys.stdin.readline().rstrip())
data = []
res = []
gcd = 0
for i in range(tc):
    data.append(int(sys.stdin.readline().rstrip()))
    if i == 1:
        gcd = abs(data[1] - data[0])
    gcd = math.gcd(abs(data[i] - data[i-1]), gcd)
gcd_res = int(gcd ** 0.5)
for i in range(2, gcd_res + 1):
    if gcd % i == 0:
        res.append(i)
        res.append(gcd//i)
res.append(gcd)
res = list(set(res))
res.sort()
for i in res:
    print(i, end = ' ')
