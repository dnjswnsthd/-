import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))
data.sort()

for i in combinations(data, m):
    print(' '.join(map(str, i)))
