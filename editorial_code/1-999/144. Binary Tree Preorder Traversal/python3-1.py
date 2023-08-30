class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        answer = []
        stack = [root]

        # Note that we add curr_node's right child to the stack first.
        while stack:
            curr_node = stack.pop()
            if curr_node:
                answer.append(curr_node.val)
                stack.append(curr_node.right)
                stack.append(curr_node.left)
                
        return answer