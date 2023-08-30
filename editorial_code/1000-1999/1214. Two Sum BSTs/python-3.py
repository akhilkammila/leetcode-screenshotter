# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def twoSumBSTs(self, root1: Optional[TreeNode], root2: Optional[TreeNode], target: int) -> bool:
        def dfs(curr_node, node_list):
            if not curr_node:
                return
            dfs(curr_node.left, node_list)
            node_list.append(curr_node.val)
            dfs(curr_node.right, node_list)
        
        node_list1, node_list2 = [], []
        dfs(root1, node_list1)
        dfs(root2, node_list2)
        
        pointer1 = 0
        pointer2 = len(node_list2) - 1
        while pointer1 < len(node_list1) and pointer2 >= 0:
            if node_list1[pointer1] + node_list2[pointer2] == target:
                return True
            elif node_list1[pointer1] + node_list2[pointer2] < target:
                pointer1 += 1
            else:
                pointer2 -= 1
        return False