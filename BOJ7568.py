import sys

class sol:
    def __init__(self, n, data):
        self.n = n
        self.data = data
        
    def bigger(self):
        for i in self.data:
            rank = 1
            for j in self.data:
                if(i[0] < j[0]) and (i[1] < j[1]):
                    rank += 1
            print(rank, end=" ")
    def get_answer(self):
        self.bigger()

if __name__ == "__main__":
    n = int(sys.stdin.readline().rstrip())
    data = []
    for _ in range(n):
        weight,height = map(int, sys.stdin.readline().rstrip().split())
        data.append((weight, height))
    sol = sol(n, data)
    sol.get_answer()
