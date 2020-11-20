import sys

n = int(sys.stdin.readline().rstrip())
data = [list(sys.stdin.readline().rstrip()) for _ in range(n)]

def sol(n, x, y):
    if n == 1:
        print(data[x][y],end="")
        return
    chk = True
    for i in range(x, x+n):
        if not chk:
            break
        for j in range(y, y+n):
            if data[i][j] != data[x][y]:
                chk = False
                break
    if chk:
        print(data[x][y], end="")
    else:
        n_tmp = n // 2

        print("(", end="")
        sol(n_tmp, x, y)
        sol(n_tmp, x, y + n_tmp)
        sol(n_tmp, x + n_tmp, y)
        sol(n_tmp, x + n_tmp, y + n_tmp)
        print(")", end="")

sol(n, 0, 0)
