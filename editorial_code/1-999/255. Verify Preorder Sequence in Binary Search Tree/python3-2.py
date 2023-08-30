class Solution:
    def verifyPreorder(self, preorder: List[int]) -> bool:
        def helper(i, min_limit, max_limit):
            if i[0] == len(preorder):
                return True
            
            root = preorder[i[0]]
            if not min_limit < root < max_limit:
                return False

            i[0] += 1
            left = helper(i, min_limit, root)
            right = helper(i, root, max_limit)
            return left or right
            
        return helper([0], -inf, inf)