class Solution:    
    def findDuplicate(self, nums: List[int]) -> int:
	
        def store(nums: List[int], cur: int) -> int:
            if cur == nums[cur]:
                return cur
            nxt = nums[cur]
            nums[cur] = cur
            return store(nums, nxt)
        
        return store(nums, 0)