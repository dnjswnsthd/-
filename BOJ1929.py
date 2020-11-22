import sys
import math

def sol(i):
    if i == 1:
        return False
    for j in range(2, int(math.sqrt(i))+1):
        if i / j == 1:
            break
        elif i % j == 0:
            return False
    return True

n, m = map(int, sys.stdin.readline().rstrip().split())
for k in range(n, m+1):
    if sol(k) == True:
        print(k)
