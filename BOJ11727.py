import sys
n = int(sys.stdin.readline().rstrip())

data = [1,3]

for i in range(2, n):
    data.append(data[i-2]*2 + data[i-1])

print(data[n-1]%10007)
