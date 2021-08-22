num = int(input())

old = {}

for i in range(num):
    student = input().split()
    old[student[0]] = [int(student[1]), int(student[2]), int(student[3])]
    #student[3] = 연도
old2 = sorted(old.items(), key=lambda x: (x[1][2], x[1][1], x[1][0]), reverse=True)

print(old2[0][0])
print(old2[-1][0])
