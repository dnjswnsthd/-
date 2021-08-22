import sys

def sol(i, j, n):
    if n == 1:
        return [0, 1] if data[i][j] == 1 else [1, 0]
    left_up = sol(i, j, n//2)
    right_up = sol(i, j+n//2, n//2)
    left_down = sol(i+n//2, j, n//2)
    right_down = sol(i+n//2, j+n//2, n//2)

    if left_up == right_up == left_down == right_down == [0, 1] or left_up == right_up == left_down == right_down == [1, 0]:
        return left_up
    else:
        return list(map(sum, zip(left_up, right_up, left_down, right_down)))


n = int(sys.stdin.readline().rstrip())
data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
print(*sol(0, 0, n), sep="\n")
