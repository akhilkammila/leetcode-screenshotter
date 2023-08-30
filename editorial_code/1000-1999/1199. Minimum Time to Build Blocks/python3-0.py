class Solution:
    def minBuildTime(self, blocks, split):
        n = len(blocks)

        # Sort the blocks in descending order
        blocks.sort(reverse=True)   

        # dp[i][j] represents the minimum time taken to 
        # build blocks[i~n-1] block using j workers
        dp = [[-1] * (n + 1) for _ in range(n)]

        def solve(b, w):
            # Base cases
            if b == n:
                return 0
            if w == 0:
                return float('inf')
            if w >= n - b:
                return blocks[b]

            # If the sub-problem is already solved, return the result
            if dp[b][w] != -1:
                return dp[b][w]

            # Two Choices
            work_here = max(blocks[b], solve(b + 1, w - 1))
            split_here = split + solve(b, min(2 * w, n - b))

            # Store the result in the dp array
            dp[b][w] = min(work_here, split_here)
            return dp[b][w]

        # For block from index 0, with 1 worker
        return solve(0, 1)