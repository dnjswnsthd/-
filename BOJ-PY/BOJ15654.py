import sys
from itertools import permutations

n, m = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))
data.sort()

for i in permutations(data, m):
    print(' '.join(map(str, i)))
