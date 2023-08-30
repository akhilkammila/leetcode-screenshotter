class Solution:
    def closestKValues(self, root: TreeNode, target: float, k: int) -> List[int]:
        def dfs(node, arr):
            if not node:
                return
            
            dfs(node.left, arr)
            arr.append(node.val)
            dfs(node.right, arr)
        
        arr = []
        dfs(root, arr)
        
        left = bisect_left(arr, target) - 1
        right = left + 1
        ans = []
        
        while len(ans) < k:
            if right == len(arr) or abs(arr[left] - target) < abs(arr[right] - target):
                ans.append(arr[left])
                left -= 1
            else:
                ans.append(arr[right])
                right += 1
        
        return ans