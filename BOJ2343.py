import sys
n, m = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))

def sol(mid):
    tmp = 0
    cnt = 1
    for i in range(n):
        if mid < data[i]:
            return False
        if tmp + data[i] <= mid:
            tmp += data[i]
        else:
            tmp = data[i]
            cnt += 1
    return cnt <= m

start = 1
end = sum(data)
res = 0

while start <= end:
    mid = (start + end) //2
    if sol(mid):
        res = mid
        end = mid - 1
    else:
        start = mid + 1
print(res)
