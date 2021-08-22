import sys

class sol:
    def __init__(self, n):
        self.N = n
        self.move = []
        
    def hanoi(self, n, a, b, c):
        if n == 1:
            self.move.append([a,c])
        else:
            self.hanoi(n-1, a, c, b)
            self.move.append([a,c])
            self.hanoi(n-1, b, a, c)
        return
    def get_answer(self):
        self.hanoi(self.N, 1, 2, 3)
        print(len(self.move))
        print("\n".join([' '.join(str(i) for i in row) for row in self.move]))


if __name__ == "__main__":
    n = int(sys.stdin.readline().rstrip())
    sol = sol(n)
    sol.get_answer()
