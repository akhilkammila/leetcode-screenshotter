class Solution:
    def __init__(self):
        # Hashmap to map old tree's nodes with new tree's nodes.
        self.seen: dict = {None: None}
            
    # Function to traverse on the sub graph of 'root'.
    def bfs(self, root: 'Optional[Node]') -> 'Optional[NodeCopy]':
        if not root:
            return None

        pending = deque()
        # Push root in queue, mark it as seen and, 
        # store its respective new node.
        pending.append(root)
        self.seen[root] = NodeCopy(root.val)
        
        while pending:
            old_node = pending.popleft()
            new_node = self.seen[old_node]
            
            # Traverse on left, right and random edges one-by-one, if nodes exist and, 
            # not already seen then we push it in queue, create a copy and attach it to new node.
            if old_node.left:
                if not old_node.left in self.seen:
                    pending.append(old_node.left)
                    self.seen[old_node.left] = NodeCopy(old_node.left.val)
                new_node.left = self.seen[old_node.left]

            if old_node.right:
                if not old_node.right in self.seen:
                    pending.append(old_node.right)
                    self.seen[old_node.right] = NodeCopy(old_node.right.val)
                new_node.right = self.seen[old_node.right]

            if old_node.random:
                if not old_node.random in self.seen:
                    pending.append(old_node.random)
                    self.seen[old_node.random] = NodeCopy(old_node.random.val)
                new_node.random = self.seen[old_node.random]

        return self.seen[root]

    def copyRandomBinaryTree(self, root: 'Optional[Node]') -> 'Optional[NodeCopy]':
        # Traverse on each node of the given tree.
        new_root = self.bfs(root)
        return new_root