import sys
from math import gcd

n, m = map(int, sys.stdin.readline().rstrip().split())
print(gcd(n,m))
print((n*m)//gcd(n,m))

