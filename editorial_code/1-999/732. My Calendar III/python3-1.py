from collections import Counter


class MyCalendarThree:

    def __init__(self):
        self.vals = Counter()
        self.lazy = Counter()

    def update(self, start: int, end: int, left: int = 0, right: int = 10**9, idx: int = 1) -> None:
        if start > right or end < left:
            return

        if start <= left <= right <= end:
            self.vals[idx] += 1
            self.lazy[idx] += 1
        else:
            mid = (left + right)//2
            self.update(start, end, left, mid, idx*2)
            self.update(start, end, mid+1, right, idx*2 + 1)
            self.vals[idx] = self.lazy[idx] + \
                max(self.vals[2*idx], self.vals[2*idx+1])

    def book(self, start: int, end: int) -> int:
        self.update(start, end-1)
        return self.vals[1]