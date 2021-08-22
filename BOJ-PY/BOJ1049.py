import sys
p = o = 1000
n, m = map(int, sys.stdin.readline().rstrip().split(' '))
for i in range (m):
    pd, od = map(int, sys.stdin.readline().rstrip().split(' '))
    p = min(p, pd)
    o = min(o, od)

if p > 6 * o:
    p = 6 * o
if ((n % 6) * o > p):
    print(int(n/6) * p + p)
else:
    print(int(n/6)*p + int(n%6)*o)

