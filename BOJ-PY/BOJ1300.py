import sys
n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())

fir, last = 1, m

while fir <= last:
    mid = (fir + last) //2

    tmp = 0
    for i in range(1, n+1):
        tmp += min(mid//i, n)
    if tmp >= m:
        ans = mid
        last = mid - 1
    else:
        fir = mid + 1
print(ans)
