import sys

class sol:

    def __init__(self,inp):
        self.INP = inp
        self.map = [['*' for _ in range(inp)] for _ in range(inp)]

    def print_map(self):
        for s in self.map:
            print(*s, sep='')

    def insert_space(self, n):
        x_i = 0
        y_i = 0
        while True:
            x = x_i * n
            y = y_i * n
            if y >= self.INP:
                break
            if x >= self.INP:
                x_i = 0
                y_i += 1
                continue
            for i in range(y + int(n/3), y + int(n/3)*2):
                for j in range(x + int(n/3), x + int(n/3)*2):
                    self.map[i][j] = ' '
            x_i += 1

    def get_answer(self):
        i = self.INP
        while True:
            if i == 1:
                break
            self.insert_space(i)
            i = int(i/3)
        self.print_map()


if __name__ == "__main__":
    inp = int(sys.stdin.readline().rstrip())
    sol = sol(inp)
    sol.get_answer()
