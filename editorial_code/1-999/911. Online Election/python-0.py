class TopVotedCandidate(object):

    def __init__(self, persons, times):
        self.A = []
        self.count = collections.Counter()
        for p, t in zip(persons, times):
            self.count[p] = c = self.count[p] + 1
            while len(self.A) <= c: self.A.append([])
            self.A[c].append((t, p))

    def q(self, t):
        lo, hi = 1, len(self.A)
        while lo < hi:
            mi = (lo + hi) / 2
            if self.A[mi][0][0] <= t:
                lo = mi + 1
            else:
                hi = mi
        i = lo - 1
        j = bisect.bisect(self.A[i], (t, float('inf')))
        return self.A[i][j-1][1]