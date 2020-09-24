import sys

tc = int(sys.stdin.readline().rstrip())

for i in range(tc):
    a = list(map(int, sys.stdin.readline().rstrip().split()))
    a.sort()
    print(a[-3])
