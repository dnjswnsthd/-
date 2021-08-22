import sys
n = int(sys.stdin.readline().rstrip())
data = set(map(int, sys.stdin.readline().rstrip().split()))
data = sorted(data)
for i in data:
    print(i, end=" ")
