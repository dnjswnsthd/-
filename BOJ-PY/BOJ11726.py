import sys
n = int(sys.stdin.readline().rstrip())
data = [1, 2]


for i in range(2, n):
    data.append(data[i-1] + data[i-2])
print(data[n-1]%10007)
