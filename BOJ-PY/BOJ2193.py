import sys

n = int(sys.stdin.readline().rstrip())
data = [0, 1, 1]
if n == 1 or n == 2:
    print(1)
else:
    for i in range(3, n+1):
        data.append(data[i-1] + data[i-2])
    print(data[n])
    
