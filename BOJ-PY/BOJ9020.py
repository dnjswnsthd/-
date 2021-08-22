import sys

data = [0 for i in range(10001)]
data[1] = 1
for i in range(2, 98):
    for j in range(i*2, 10001, i):
        data[j] = 1

n = int(sys.stdin.readline().rstrip())
for i in range(n):
    d = int(sys.stdin.readline().rstrip())
    a = d//2
    for j in range(a, 1, -1):
        if data[d-j] == 0 and data[j] == 0:
            print(j, d - j)
            break
