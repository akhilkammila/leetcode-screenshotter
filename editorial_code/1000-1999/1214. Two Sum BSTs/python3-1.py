# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def twoSumBSTs(self, root1: Optional[TreeNode], root2: Optional[TreeNode], target: int) -> bool:
        def binarySearch(root2, target2):
            if not root2:
                return False
            if root2.val == target2:
                return True
            elif root2.val > target2:
                return binarySearch(root2.left, target2)
            else:
                return binarySearch(root2.right, target2)

        def dfs(root, target):
            if not root:
                return False
            if binarySearch(root2, target - root.val):
                return True
            return dfs(root.left, target) or dfs(root.right, target)

        return dfs(root1, target)