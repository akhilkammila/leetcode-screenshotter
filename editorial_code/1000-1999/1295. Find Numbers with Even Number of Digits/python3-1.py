class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        # Counter to count the number of even digit integers
        even_digit_count = 0

        for num in nums:
            # Convert num to string and find its length
            length = len(str(num))
            if length % 2 == 0:
                even_digit_count += 1

        return even_digit_count