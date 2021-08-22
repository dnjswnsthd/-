import sys

n= int(sys.stdin.readline().rstrip())
data = [0 for i in range(10001)]

for i in range(n):
    data[int(sys.stdin.readline())] += 1
for i in range(10001):
    sys.stdout.write('%s\n' % i * data[i])
