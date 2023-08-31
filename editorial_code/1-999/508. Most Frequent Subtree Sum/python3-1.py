class Solution:    
    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
        self.sum_freq = {}
        self.max_freq = 0
        
        def sub_tree_sum(root) -> int:
            if not root:
                return 0

            # Get left and right subtree's sum.
            left_subtree_sum = sub_tree_sum(root.left)
            right_subtree_sum = sub_tree_sum(root.right)

            # Use child's tree's sums to get current root's tree's sum
            curr_sum = root.val + left_subtree_sum + right_subtree_sum

            self.sum_freq[curr_sum] = self.sum_freq.get(curr_sum, 0) + 1
            self.max_freq = max(self.max_freq, self.sum_freq[curr_sum])
            return curr_sum
        
        # Traverse on all nodes one by one, and find it's tree's sum.
        sub_tree_sum(root)
        max_freq_sums = []
        for sum in self.sum_freq:
            if self.sum_freq[sum] == self.max_freq:
                max_freq_sums.append(sum)
        
        return max_freq_sums