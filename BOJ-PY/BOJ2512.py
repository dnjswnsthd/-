import sys
n = int(sys.stdin.readline())
budget = list(map(int, sys.stdin.readline().split()))
total = int(sys.stdin.readline())
lo, hi = 0, max(budget)
while lo != hi: 
    mi = (lo + hi + 1)//2
    tmp = sum(map(lambda x: x if x < mi else mi, budget))
    if tmp > total:
        hi = mi-1 
    elif tmp < total:
        lo = mi 
    else:
        lo = hi = mi 
print(hi)

