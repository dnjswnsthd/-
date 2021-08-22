def next_permutation(arr):

    n = len(arr)-1
    if n==0:
        return -1
    i = n
    while arr[i-1] < arr[i]:
        i -= 1
        if i == 0:
            return -1

    j = i-1
    diff = -10000
    position_to_switch = 0
    for k in range(i, n+1):
        if arr[k]-arr[j] < 0:
            diff = max(diff, arr[k]-arr[j])
    for m in range(i, n+1):
        if arr[m]==arr[j]+diff:
            position_to_switch = m
            break
    temp = arr[j]
    arr[j] = arr[position_to_switch]
    arr[position_to_switch] = temp
    temp_list = arr[j+1:]
    temp_list.sort()
    temp_list.reverse()
    arr = arr[:j+1]
    arr = arr + temp_list
    #arr[j+1:].sort()
    return arr

if __name__=='__main__':

    num = int(input())
    arr = list(map(int, input().split()))
    result = next_permutation(arr)
    if result == -1:
        print(-1)
    else:
        for p in result:
            print(p, end=' ') 
