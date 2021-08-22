import sys
n = int(sys.stdin.readline().rstrip())
data = []

for i in range(n):
    m = int(sys.stdin.readline().rstrip())
    data.append(m)
data.sort()
for i in range(n):
    print(data[i])

