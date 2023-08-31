class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        min_heap = []
        taken = set()
        
        for index in range(len(nums)):
            # If current number was already taken, skip it.
            if nums[index] in taken:
                continue
            
            # If min heap already has three numbers in it.
            # Pop the smallest if current number is bigger than it.
            if len(min_heap) == 3:
                if min_heap[0] < nums[index]:
                    taken.remove(min_heap[0])
                    heappop(min_heap)
                    
                    heappush(min_heap, nums[index])
                    taken.add(nums[index])
                    
            # If min heap does not have three number we can push it.
            else:
                heappush(min_heap, nums[index])
                taken.add(nums[index])
        
        # 'nums' has only one distinct element it will be the maximum.
        if len(min_heap) == 1:
            return min_heap[0]
        
        # 'nums' has two distinct elements.
        elif len(min_heap) == 2:
            first_num = min_heap[0]
            heappop(min_heap)
            return max(first_num, min_heap[0])
        
        return min_heap[0]