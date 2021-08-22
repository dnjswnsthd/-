import sys

n = int(sys.stdin.readline().rstrip())
for i in range(n):
    cnt = 0
    a, b = map(str, sys.stdin.readline().rstrip().split())
    for i in range(int(a),int(b)+1, 1):
        cnt += str(i).count("0")
    print(cnt)
