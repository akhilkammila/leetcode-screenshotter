class Solution:
    def sortTransformedArray(self, nums: List[int], a: int, b: int, c: int) -> List[int]:
        def transform(x):
            # Return the transformed result for element 'x'
            return (a * x * x) + (b * x) + c

        answer = []
        left, right = 0, len(nums) - 1
        
        if a < 0:
            # When 'downward parabola' we will put the edge element (smaller elements) first.
            while left <= right:
                left_transformed_val = transform(nums[left])
                right_transformed_val = transform(nums[right])
                if left_transformed_val < right_transformed_val:
                    answer.append(left_transformed_val)
                    left += 1
                else:
                    answer.append(right_transformed_val)
                    right -= 1
        else:
            while left <= right:
                # When 'upward parabola' or a 'straight line' 
                # we will put the edge element (bigger elements) first.
                left_transformed_val = transform(nums[left])
                right_transformed_val = transform(nums[right])
                if left_transformed_val > right_transformed_val:
                    answer.append(left_transformed_val)
                    left += 1
                else:
                    answer.append(right_transformed_val)
                    right -= 1
            # Reverse the decreasing 'answer' array.
            answer.reverse()
        return answer