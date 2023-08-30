class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        queue_o = deque([original,])
        queue_c = deque([cloned,])

        while queue_o:
            node_o = queue_o.popleft()
            node_c = queue_c.popleft()
            
            if node_o is target:
                return node_c

            if node_o:
                queue_o.append(node_o.left)
                queue_o.append(node_o.right)
                
                queue_c.append(node_c.left)
                queue_c.append(node_c.right) 