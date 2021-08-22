import sys
N, M = map(int, input().split())
matrix = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
 
for i in range(N):
    for j in range(N):
        if j == 0:
            pass
        else:
            matrix[i][j] += matrix[i][j-1] 

for _ in range(M):
    i, j, x, y = map(int, sys.stdin.readline().split())
    answer = 0
    for k in range(i-1, x):
        if j != 1:
            answer -= matrix[k][j-2]
        answer += matrix[k][y-1]
    print(answer)
