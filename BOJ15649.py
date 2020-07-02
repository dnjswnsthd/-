import sys

class Solution:

    def __init__(self, n, m):
        self.N = n
        self.M = m
        self.arr = [0 for _ in range(m)]
        self.visited = [False for _ in range(n + 1)]

    def backtracking(self, c, n, m):
        if c == m:
            for v in self.arr:
                print(v, end=' ')
            print()
            return
        for i in range(1, n + 1):
            if self.visited[i] is False:
                self.arr[c] = i
                self.visited[i] = True
                self.backtracking(c + 1, n, m)
                self.visited[i] = False

    def get_answer(self):
        self.backtracking(0, self.N, self.M)


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().rstrip().split())
    s = Solution(N, M)
    s.get_answer()
