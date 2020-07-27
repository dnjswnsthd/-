import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
que = deque([])
for i in range(n):
    s = sys.stdin.readline().split()
    if s[0] == "push_back":
        que.append(s[1])
    elif s[0] == "push_front":
        que.appendleft(s[1])
    elif s[0] == "front":
        if not que:
            print(-1)
        else:
            print(que[0])
    elif s[0] == "back":
        if not que:
            print(-1)
        else:
            print(que[-1])
    elif s[0] == "size":
        print(len(que))
    elif s[0] == "empty":
        if not que:
            print(1)
        else:
            print(0)
    elif s[0] == "pop_front":
        if not que:
            print(-1)
        else:
            print(que.popleft())
    elif s[0] == "pop_back":
        if not que:
            print(-1)
        else:
            print(que.pop())
