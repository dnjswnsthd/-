case = int(input())

for _ in range(case):
    function = list(input())
    num = int(input())
    arr = eval(input())
    
    error = False
    R_count = 0 
    D_front = 0 
    
    for func in function:            
        if func == 'R':
            R_count += 1
        else:
            try:
                if R_count % 2 == 0:
                    D_front += 1 
                else:
                    arr.pop() 
            except:
                error = True
                break

    if error or D_front > len(arr):
        print('error')
        continue

    if R_count % 2 == 0:
        answer = arr[D_front:]
    else:
        answer = list(reversed(arr[D_front:]))

    print("[", end='')
    for i in range(len(answer)):
        if i == len(answer) - 1:
            print(answer[i], end = '')
        else:
            print("%s," %(answer[i]), end='')
    print("]")
 
