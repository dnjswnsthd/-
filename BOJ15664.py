import sys
from itertools import permutations

n, m = map(int, sys.stdin.readline().rstrip().split())
data = sorted(list(map(int, sys.stdin.readline().rstrip().split())))

for i in sorted(set(permutations(data, m)), key=lambda *x:[i for i in x]):
    i = list(i)
    for j in range(len(i)-1):
        if i[j] > i[j+1]:
            break
    else:
        print(' '.join(list(map(str, i))))
