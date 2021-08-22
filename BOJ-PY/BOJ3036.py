import sys
from math import gcd
n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
for i in range(1, n):
    if (data[0] % data[i]) == 0:
        print(data[0] // data[i], end="")
        print("/", end="")
        print(1)
    else:
        tmp = gcd(data[0], data[i])
        print(data[0]//tmp, end="")
        print("/", end="")
        print(data[i]//tmp)
