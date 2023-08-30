class Solution:
    def closestKValues(self, root: TreeNode, target: float, k: int) -> List[int]:
        def dfs(node, heap):
            if not node:
                return
            
            heappush(heap, (-abs(node.val - target), node.val))
            if len(heap) > k:
                heappop(heap)

            dfs(node.left, heap)
            dfs(node.right, heap)
        
        heap = []
        dfs(root, heap)
        return [x[1] for x in heap]