import sys
tc = int(sys.stdin.readline().rstrip())
data = []
for i in range(tc):
    n = int(sys.stdin.readline().rstrip())
    data.append(n)
res = [1,2,4]
for i in range(3, max(data)):
    res.append(res[i-1]+res[i-2]+res[i-3])
for i in range(tc):
    print(res[data[i]-1])
