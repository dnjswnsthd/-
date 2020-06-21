import sys

class sol:
    def __init__(self, n, m):
        self.N = n
        self.M = m
        self.arr = [0 for _ in range(m + 1)]
        self.visited = [False for _ in range(n + 1)]

    def backtracking(self, c, n, m):
        if c == m:
            for i in range(1,len(self.arr)):
                print(self.arr[i],end=' ')
            print()
            return
        
        for i in range(1, n + 1):
            if self.visited[i] is False and self.arr[c] < i:
                self.arr[c + 1] = i
                self.visited[i] = True
                self.backtracking(c +1, n, m)
                self.visited[i] = False
                
            
    def get_answer(self):
        self.backtracking(0, self.N, self.M)

if __name__ == "__main__":
    N,M = map(int, sys.stdin.readline().rstrip().split())
    s = sol(N,M)
    s.get_answer()
