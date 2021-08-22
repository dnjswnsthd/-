import sys

class sol:

    def __init__(self, n, m):
        self.N = n
        self.M = m
        self.arr = [0 for _ in range(m)]
        self.visited = [False for _ in range(n + 1)]

    def backtracking(self, c, n, m):
        if c == m:
            is_sorted = all(self.arr[i] <= self.arr[i+1] for i in range(len(self.arr)-1))
            if(is_sorted == True):
                for v in self.arr:
                    print(v, end=' ')
                print()
                return
            else:
                return
        for i in range(1, n + 1):
            if self.visited[c] is False:
                self.arr[c] = i
                self.visited[c] = True
                self.backtracking(c + 1, n, m)
                self.visited[c] = False

    def get_answer(self):
        self.backtracking(0, self.N, self.M)


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().rstrip().split())
    s = sol(N, M)
    s.get_answer()
