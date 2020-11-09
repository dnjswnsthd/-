import sys

n = int(sys.stdin.readline().rstrip())

cnt = 0
for i in range(n):
    s = str(sys.stdin.readline().rstrip())
    if list(s) == sorted(s, key=s.find):
        cnt +=1
print(cnt)
