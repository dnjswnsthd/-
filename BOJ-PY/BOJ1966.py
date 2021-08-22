import sys
t = int(sys.stdin.readline().rstrip())
for i in range(t):
    n, m = map(int, sys.stdin.readline().rstrip().split())
    data = list(map(int, sys.stdin.readline().rstrip().split()))
    data_ind = [0 for i in range(n)]
    data_ind[m] = 1
    cnt = 0
    while True:
        if data[0] == max(data):
            cnt += 1
            if data_ind[0] == 1:
                print(cnt)
                break
            else:
                del data[0]
                del data_ind[0]
        else:
            data.append(data[0])
            del data[0]
            data_ind.append(data_ind[0])
            del data_ind[0]
