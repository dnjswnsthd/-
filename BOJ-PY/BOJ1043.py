import sys

cnt = int(sys.stdin.readline().rstrip().split()[1])
w_set = set(sys.stdin.readline().rstrip().split()[1:])
party = []
po = []

for _ in range(cnt):
    party.append(set(sys.stdin.readline().rstrip().split()[1:]))
    po.append(1)
    for _ in range(cnt):
        for i, p in enumerate(party):
            if w_set.intersection(p):
                po[i] = 0
                w_set = w_set.union(p)

print(sum(po))
