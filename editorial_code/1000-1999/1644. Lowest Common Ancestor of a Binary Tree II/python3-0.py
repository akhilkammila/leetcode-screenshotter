def LCA(node, p, q):
    if node is None or node == p or node == q:
        return node
    left = LCA(node.left, p, q)
    right = LCA(node.right, p, q)
    if left and right:
        return node
    elif left:
        return left
    else:
        return right