import sys
input = sys.stdin.readline
def inorder(root, level):
    global num
    if s[root][0] != -1:
        inorder(s[root][0], level + 1)
    row[level].append(num)
    num += 1
    if s[root][1] != -1:
        inorder(s[root][1], level + 1)
n = int(input())
s = [[0] * 2 for i in range(n + 1)]
node = [0 for i in range(n + 1)]
row = [[] for i in range(n + 1)]
num = 1
for i in range(n):
    ro, le, ri = map(int, input().split())
    s[ro][0] = le
    s[ro][1] = ri
    node[ro] += 1
    if le != -1:
        node[le] += 1
    if ri != -1:
        node[ri] += 1
for i in range(1, n + 1):
    if node[i] == 1:
        root = i
inorder(root, 1)
result = max(row[1]) - min(row[1]) + 1
level = 1
for i in range(2, n + 1):
    if row[i]:
        if result < max(row[i]) - min(row[i]) + 1:
            result = max(row[i]) - min(row[i]) + 1
            level = i
print(level, result)
