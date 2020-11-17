import sys

def cnt(n, m):
    cn = 0
    tmp = m
    while(n >= tmp):
        cn = cn + (n // tmp)
        tmp *= m
    return cn

n, m = map(int, sys.stdin.readline().rstrip().split())
print(min(cnt(n, 5) - cnt(m, 5) - cnt(n-m, 5), cnt(n, 2) - cnt(m, 2) - cnt(n-m, 2)))
