import sys

class sol:
    def __init__(self, n):
        self.n = n

    def facto(self):
        t = 2
        while (t <= self.n):
            if self.n % t == 0:
                    print(t)
                    self.n /= t
            else:
                t += 1

    def get_ans(self):
        self.facto()

if __name__ == "__main__" :
    n = int(sys.stdin.readline().rstrip())
    sol = sol(n)
    sol.get_ans()
