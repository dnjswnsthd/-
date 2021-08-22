import sys
def fact(a):
    res = 1
    for i in range(1, a+1):
        res *= i
    return res


n, m = map(int,sys.stdin.readline().rstrip().split())
n = n
m = m
tmp_n = fact(n)
tmp_m = fact(m)
tmp_nm = fact((n-m))

print((tmp_n//(tmp_m*tmp_nm))%10007)
