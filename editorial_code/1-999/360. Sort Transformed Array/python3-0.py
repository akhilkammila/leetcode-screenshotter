class Solution:
    def sortTransformedArray(self, nums: List[int], a: int, b: int, c: int) -> List[int]:
        answer = []
        for num in nums:
            # Push transformed value in the 'answer' array.
            answer.append((a * num * num) + (b * num) + c)
        # Sort the array of transformed values.
        answer.sort()
        return answer