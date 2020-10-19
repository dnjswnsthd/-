import sys
n, m = map(int, sys.stdin.readline().rstrip().split())
inpp = [sys.stdin.readline().rstrip() for i in range(n)]
person = [sys.stdin.readline().rstrip() for i in range(n)]

dup = list(set(inpp) & set(person))

print(len(dup))
for i in sorted(dup):
    print(i)
