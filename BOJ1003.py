import sys

def cnt(n):
    cnt_z = [1,0]
    cnt_o = [0,1]
    if n <= 1:
        return
    for i in range(2, n+1, 1):
        cnt_z.append(cnt_z[i-1] + cnt_z[i-2])
        cnt_o.append(cnt_o[i-1] + cnt_o[i-2])
 
    return cnt_z, cnt_o
 
n = int(sys.stdin.readline().rstrip())
cnt_z, cnt_o = cnt(40)
 
for _ in range(n):
    m = int(sys.stdin.readline().rstrip())
    print("%d %d" % (cnt_z[m], cnt_o[m]))
