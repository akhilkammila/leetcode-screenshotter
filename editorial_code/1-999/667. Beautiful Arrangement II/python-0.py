class Solution(object):
    def constructArray(self, n, k):
        seen = [False] * n
        def num_uniq_diffs(arr):
            ans = 0
            for i in range(n):
                seen[i] = False
            for i in range(len(arr) - 1):
                delta = abs(arr[i] - arr[i+1])
                if not seen[delta]:
                    ans += 1
                    seen[delta] = True
            return ans

        for cand in itertools.permutations(range(1, n+1)):
            if num_uniq_diffs(cand) == k:
                return cand