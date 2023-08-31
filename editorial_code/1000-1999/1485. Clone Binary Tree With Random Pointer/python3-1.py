class Solution:
    def __init__(self):
        # Hashmap to map old tree's nodes with new tree's nodes.
        self.seen: dict[str, int] = {None: None}
            
    # Function to traverse on the sub graph of 'root'.
    def dfs(self, root: 'Optional[Node]') -> 'Optional[NodeCopy]':
        if not root:
            return None

        if self.seen.get(root) is not None:
            return self.seen.get(root)

        new_root = NodeCopy(root.val)
        # Mark old root as seen and store its respective new node.
        self.seen[root] = new_root
        
        # Traverse on all 3 edges of root and attach respective new node
        # to the newRoot.
        new_root.left = self.dfs(root.left)
        new_root.right = self.dfs(root.right)
        new_root.random = self.dfs(root.random)
        return new_root

    def copyRandomBinaryTree(self, root: 'Optional[Node]') -> 'Optional[NodeCopy]':
        # Traverse on each node of the given tree.
        new_root = self.dfs(root)
        return new_root