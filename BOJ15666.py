import sys

def sol(arr, i):
    if i == m:
        print(' '.join(list(map(str, arr))))
    else:
        if i == 0:
            for j in data:
                sol(arr+[j], i+1)
                
        else:
            for j in data:
                if j >= arr[-1]:
                    sol(arr+[j], i+1)

n, m = map(int, sys.stdin.readline().rstrip().split())
data = sorted(set(map(int, sys.stdin.readline().rstrip().split())))


sol([], 0)
