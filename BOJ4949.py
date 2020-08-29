import sys
while True:
    s = str(sys.stdin.readline().rstrip())
    if s == '.':
        break
    data = []
    tmp = True
    for i in s:
        if i == "(" or i == "[":
            data.append(i)
        elif i == ")":
            if not data or data[-1] == '[':
                tmp = False
                break
            elif data[-1] == "(":
                data.pop()
        elif i == "]":
            if not data or data[-1] == "(":
                tmp = False
                break
            elif data[-1] == "[":
                data.pop()
    if tmp == True and not data:
        print("yes")
    else:
        print("no")
