class Solution:
    def closestKValues(self, root: TreeNode, target: float, k: int) -> List[int]:
        def dfs(node, queue):
            if not node:
                return
            
            dfs(node.left, queue)
            queue.append(node.val)
            if len(queue) > k:
                if (abs(target - queue[0]) < abs(target - queue[-1])):
                    queue.pop()
                    return
                else:
                    queue.popleft()
                    
            dfs(node.right, queue)
        
        queue = deque()
        dfs(root, queue)
        return queue