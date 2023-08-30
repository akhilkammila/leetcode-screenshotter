class Window:
    def __init__(self):
        self.count = collections.Counter()
        self.nonzero = 0

    def add(self, x):
        self.count[x] += 1
        if self.count[x] == 1:
            self.nonzero += 1

    def remove(self, x):
        self.count[x] -= 1
        if self.count[x] == 0:
            self.nonzero -= 1

class Solution(object):
    def subarraysWithKDistinct(self, A, K):
        window1 = Window()
        window2 = Window()
        ans = left1 = left2 = 0

        for right, x in enumerate(A):
            window1.add(x)
            window2.add(x)

            while window1.nonzero > K:
                window1.remove(A[left1])
                left1 += 1

            while window2.nonzero >= K:
                window2.remove(A[left2])
                left2 += 1

            ans += left2 - left1

        return ans