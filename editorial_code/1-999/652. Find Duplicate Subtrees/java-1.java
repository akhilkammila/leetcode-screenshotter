class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), new HashMap<>(), res);
        return res;
    }

    public int traverse(TreeNode node, Map<String, Integer> tripletToID,
            Map<Integer, Integer> cnt, List<TreeNode> res) {
        if (node == null) {
            return 0;
        }
        String triplet = traverse(node.left, tripletToID, cnt, res) + "," + node.val +
                "," + traverse(node.right, tripletToID, cnt, res);
        if (!tripletToID.containsKey(triplet)) {
            tripletToID.put(triplet, tripletToID.size() + 1);
        }
        int id = tripletToID.get(triplet);
        cnt.put(id, cnt.getOrDefault(id, 0) + 1);
        if (cnt.get(id) == 2) {
            res.add(node);
        }
        return id;
    }
}