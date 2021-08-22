import sys

cro = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
s = str(sys.stdin.readline().rstrip())

for i in cro:
    s = s.replace(i, 's')

print(len(s))
