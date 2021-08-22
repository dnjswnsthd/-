import sys
n, m = map(int, sys.stdin.readline().rstrip().split())
data = [sys.stdin.readline().rstrip() for _ in range(n)]
k = int(sys.stdin.readline().rstrip())
cnt = [0]*n
if k%2:
    for i in range(n):
        zero = data[i].count('0')
        if zero % 2 and zero <= k:
            for j in range(n):
                if data[i] == data[j]:
                    cnt[i] += 1

else:
    for i in range(n):
        zero = data[i].count('0')
        if not zero % 2 and zero <= k:
            for j in range(n):
                if data[i] == data[j]:
                    cnt[i] += 1
print(max(cnt))
