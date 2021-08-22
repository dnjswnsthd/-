import sys
from itertools import permutations

n, m = map(int, sys.stdin.readline().rstrip().split())
data = sorted(list(map(int, sys.stdin.readline().rstrip().split())))

for i in sorted(set(permutations(data, m)), key=lambda *x:[i for i in x]):
    print(' '.join(list(map(str, i))))
