import sys

class sol:
    def __init__(self, n):
        self.N = n
        self.cnt =0
        self.movie = 666

    def moviename(self):
        while True:
            if '666' in str(self.movie):
                self.cnt += 1
            if self.cnt == self.N:
                print(self.movie)
                break
            self.movie += 1
            
    def get_answer(self):
        self.moviename()

if __name__ == "__main__":
    n = int(input())
    sol = sol(n)
    sol.get_answer()
    
