import sys
import math

n, m = map(int, sys.stdin.readline().rstrip().split())
res_d = []
mul_data = [1 for _ in range(n, m+1)]

max_sqrt = int(math.sqrt(m))
sqrt_arr = [i*i for i in range(2, max_sqrt+1)]

for i in sqrt_arr:
    tmp = (math.ceil(n / i) * i) - n
    while tmp <= m - n:
        mul_data[tmp] = 0
        tmp += i
res = sum(mul_data)
res_d.append(res)
for res in res_d:
    print(res)
