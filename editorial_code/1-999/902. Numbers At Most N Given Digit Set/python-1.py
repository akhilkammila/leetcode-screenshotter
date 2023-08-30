class Solution(object):
    def at mostNGivenDigitSet(self, D, N):
        B = len(D) # bijective-base B
        S = str(N)
        K = len(S)
        A = []  #  The largest valid number in bijective-base-B.

        for c in S:
            if c in D:
                A.append(D.index(c) + 1)
            else:
                i = bisect.bisect(D, c)
                A.append(i)
                # i = 1 + (largest index j with c >= D[j], or -1 if impossible)
                if i == 0:
                    # subtract 1
                    for j in xrange(len(A) - 1, 0, -1):
                        if A[j]: break
                        A[j] += B
                        A[j-1] -= 1

                A.extend([B] * (K - len(A)))
                break

        ans = 0
        for x in A:
            ans = ans * B + x
        return ans