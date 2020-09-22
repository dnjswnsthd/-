from sys import stdin


class sol:

    def __init__(self, n):
        self.N = n
        self.re = 1000000

    def fibo(self, n, fibo):
        fibo[1] = 1
        fibo[2] = 1
        for i in range(3, n + 1):
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % self.re
        return fibo[n]

    def get_answer(self):
        res = 15 * self.re // 10
        fibo = [0 for _ in range(res + 1)]
        print(self.fibo(self.N % res, fibo))


if __name__ == "__main__":
        N = int(stdin.readline().rstrip())
        s = sol(N)
        s.get_answer()
