class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        n = len(answerKey)
        left, right = k, n
        
        def isValid(size):
            counter = collections.Counter(answerKey[:size])
            if min(counter['T'], counter['F']) <= k:
                return True
            for i in range(size, n):
                counter[answerKey[i]] += 1
                counter[answerKey[i - size]] -= 1
                if min(counter['T'], counter['F']) <= k:
                    return True
            return False
        
        while left < right:
            mid = (left + right + 1) // 2
            
            if isValid(mid):
                left = mid
            else:
                right = mid - 1
        
        return left