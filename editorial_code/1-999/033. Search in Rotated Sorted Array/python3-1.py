class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        left, right = 0, n - 1
        
        # Find the index of the pivot element (the smallest element)
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] > nums[-1]:
                left = mid + 1
            else:
                right = mid - 1
        
        # Shift elements in circular manner, with the pivot element at index 0.
        # Then perform a regular binary search
        def shiftedBinarySearch(pivot_index, target):
            shift = n - pivot_index
            left, right = (pivot_index + shift) % n, (pivot_index - 1 + shift) % n

            while left <= right:
                mid = (left + right) // 2
                if nums[(mid - shift) % n] == target:
                    return (mid - shift) % n
                elif nums[(mid - shift) % n] > target:
                    right = mid - 1
                else:
                    left = mid + 1
            return -1
            
        return shiftedBinarySearch(left, target)