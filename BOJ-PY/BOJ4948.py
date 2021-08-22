import sys
import math

def sol(i):
    if i == 1:
        return False
    for j in range(2, int(math.sqrt(i))+1):
        if i / j == 1:
            break
        elif i % j == 0:
            return False
    return True

data = []
while True:
    d = int(sys.stdin.readline().rstrip())
    if d == 0:
        break
    data.append(d)

for k in range(len(data)):
    cnt = 0
    for l in range(data[k]+1, data[k]*2 + 1):
        if sol(l) == True:
            cnt += 1
    print(cnt)
