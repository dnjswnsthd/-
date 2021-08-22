import sys

n = int(sys.stdin.readline().rstrip())
if n <= 1022:
    num = range(10)
    result = [[] for _ in range(11)]
    for i in range(1, 1 << 10):
        cnt = 0
        tmp = []
        for j in range(10):
            if i & 1 << j:
                cnt += 1
                tmp.insert(0, j)
        result[cnt].append(''.join(list(map(str, tmp))))
    cnt = 0
    state = False
    for arr in result:
        for e in arr:
            if cnt == n:
                print(e)
                state = True
                break
            cnt += 1
        if state:
            break
else:
    print(-1)
