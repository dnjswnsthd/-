import sys

n = int(sys.stdin.readline().rstrip())
n2 = str(n)

data = []

for i in range(len(n2)):
    data.append(n2[i])
for i in range(len(data)):
    data[i] = int(data[i])
    
data.sort(reverse=True)
for i in range(len(data)):
    print(data[i], end="")
    
