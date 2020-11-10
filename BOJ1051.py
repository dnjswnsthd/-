import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
data = []
for i in range(n):
    data.append(list(map(str, sys.stdin.readline().rstrip())))
max_data = min(n,m)
max_d = 0

for i in range(n):
    for j in range(m):
        for k in range(max_data):
            if i + k < n and j + k < m:
                if data[i][j] == data[i][j+k] and data[i][j] == data[i+k][j] and data[i][j] == data[i+k][j+k] :
                    if max_d < k:
                        max_d = k
                        
print((max_d+1)*(max_d+1))
