import sys
def sum_(n):
    if n<10:
        return n*(n+1)//2
    a = int(str(n)[0])
    b = int(str(n)[1:])
    length = len(str(n))-1
    return (45*a*length)*(10**(length-1))+(a*(a-1)//2)*(10**length)+a*(b+1)+sum_(b)
n = int(sys.stdin.readline())

for _ in range(n):
    a,b = map(int,sys.stdin.readline().split())
    print(sum_(b)-sum_(a-1))
