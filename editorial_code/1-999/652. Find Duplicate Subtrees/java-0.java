class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), res);
        return res;
    }

    public String traverse(TreeNode node, Map<String, Integer> cnt,
            List<TreeNode> res) {
        if (node == null) {
            return "";
        }
        String representation = "(" + traverse(node.left, cnt, res) + ")" +
                node.val + "(" + traverse(node.right, cnt, res) +
                ")";
        cnt.put(representation, cnt.getOrDefault(representation, 0) + 1);
        if (cnt.get(representation) == 2) {
            res.add(node);
        }
        return representation;
    }
}