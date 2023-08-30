class Solution:
    def minBuildTime(self, blocks: List[int], split: int) -> int:        
        # Prepare Heap of Building Time
        heapq.heapify(blocks)
        
        # Make sibling blocks until we are left with only one root node
        while len(blocks) > 1:            
            # Pop two minimum. The time of the abstracted sub-root will be 
            # split + max(x, y) which is split + y
            x = heapq.heappop(blocks)
            y = heapq.heappop(blocks)
            heapq.heappush(blocks, split + y)
        
        # Time of final root node
        return heapq.heappop(blocks)