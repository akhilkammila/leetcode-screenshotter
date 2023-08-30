class Solution:
    def minBuildTime(self, blocks: List[int], split: int) -> int:        
        # Sort Array in Descending Order of the required time
        blocks.sort(reverse = True)

        # If can be built in "limit"
        def possible(limit):           
            # Build all blocks starting with one worker
            worker = 1

            for index, time in enumerate(blocks):
                # If no worker or no sufficient time
                if worker <= 0 or time > limit:
                    return False
                
                # Keep splitting and producing workers as long as 
                # we are within the limit for this block
                while time + split <= limit:
                    limit -= split
                    worker *= 2

                    # Sufficient workers for the remaining block
                    if worker >= len(blocks) - index:
                        return True
                
                # Build Block
                worker -= 1

            # All blocks build
            return True

        # Binary Search Algorithm
        left = blocks[0]
        right = math.ceil(log2(len(blocks))) * split  + blocks[0]
        while left < right:
            mid = (left + right) // 2
            if possible(mid):
                right = mid
            else:
                left = mid + 1
        
        # Right is the minimum time when the task is possible
        return int(right)