import sys
from itertools import combinations
n = int(sys.stdin.readline().rstrip())
data = []
for i in range(n):
    data.append(str(sys.stdin.readline().rstrip()))
data = list(set(data))
data.sort()
data.sort(key=len)

for i in range(len(data)):
    print(data[i])
