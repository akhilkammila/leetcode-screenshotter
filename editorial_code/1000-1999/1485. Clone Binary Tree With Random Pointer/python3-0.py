class Solution:
    def __init__(self):
        # Hashmap to map old tree's nodes with new tree's nodes.
        self.new_old_pairs: dict[str, int] = {None: None}

    def deep_copy(self, root: 'Optional[Node]') -> 'Optional[NodeCopy]':
        if not root:
            return None
        new_root = NodeCopy(root.val)
        # Deep copy left subtree and attach it on new node's left.
        new_root.left = self.deep_copy(root.left)
        # Deep copy right subtree and attach it on new node's right.
        new_root.right = self.deep_copy(root.right)
        # Store the new node and old node's pair in hash map.
        self.new_old_pairs[root] = new_root
        return new_root

    def map_random_pointers(self, old_node: 'Optional[Node]') -> None:
        if not old_node:
            return
        new_node = self.new_old_pairs[old_node]
        old_node_random = old_node.random
        new_node_random = self.new_old_pairs[old_node_random]
        # Map newNode with it's respective random node.
        new_node.random = new_node_random
        # Traverse on rest nodes to map their respective new node's random pointers.
        self.map_random_pointers(old_node.left)
        self.map_random_pointers(old_node.right)

    def copyRandomBinaryTree(self, root: 'Optional[Node]') -> 'Optional[NodeCopy]':
        # Create a new tree for each node of old tree and map new node with old respective node.
        new_root = self.deep_copy(root)
        # We will assign random pointers of new tree to respective correct new nodes.
        self.map_random_pointers(root)
        return new_root