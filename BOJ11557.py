import sys
n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    m = int(sys.stdin.readline().rstrip())
    cham = []
    for _ in range(m):
        s, l = map(str, sys.stdin.readline().rstrip().split())
        cham.append([s, int(l)])
    cham = sorted(cham, key = lambda x : x[1])
    print(cham[-1][0])
