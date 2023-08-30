class Solution:
    def minBuildTime(self, blocks: List[int], split: int) -> int:        
        # Sort the blocks in descending order.
        N = len(blocks)
        blocks.sort(reverse=True)
        
        # Initialize the dp array. When all N blocks
        # done, we need 0 time.
        dp = [0] * (N + 1)

        # The case when we have no workers.
        dp[0] = float('inf')
        
        # Fill the dp array in a bottom-up fashion.
        for b in range(N - 1, -1, -1):
            for w in range(N, 0, -1):                
                # If we have more workers than blocks, 
                # Then we can build all the blocks.
                if w >= N - b:
                    dp[w] = blocks[b]
                    continue

                # Recurrence relation.
                work_here = max(blocks[b], dp[w - 1])
                split_here = split + dp[min(2 * w, N - b)]
                
                # Store the result in the dp array
                dp[w] = min(work_here, split_here)
        
        # For building all the blocks, with 
        # initially 1 worker.
        return dp[1]