class Solution:
    def verifyPreorder(self, preorder: List[int]) -> bool:
        min_limit = -inf
        i = 0
        
        for num in preorder:
            while i > 0 and preorder[i - 1] < num:
                min_limit = preorder[i - 1]
                i -= 1
                
            if num <= min_limit:
                return False
            
            preorder[i] = num
            i += 1
        
        return True