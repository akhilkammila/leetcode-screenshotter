class Solution {
    // CONSTANTS
    final int MOD_1 = 1000000007;
    final int MOD_2 = 2147483647;

    // Hashing a Node
    long[] hashSubtreeAtNode(TreeNode node, boolean needToAdd) {

        if (node == null)
            return new long[] { 3, 7 };

        long[] left = hashSubtreeAtNode(node.left, needToAdd);
        long[] right = hashSubtreeAtNode(node.right, needToAdd);

        long left1 = (left[0] << 5) % MOD_1;
        long right1 = (right[0] << 1) % MOD_1;
        long left2 = (left[1] << 7) % MOD_2;
        long right2 = (right[1] << 1) % MOD_2;

        long[] hashpair = { (left1 + right1 + node.val) % MOD_1,
                (left2 + right2 + node.val) % MOD_2 };

        if (needToAdd)
            memo.add(hashpair);

        return hashpair;
    }

    // Vector to store hashed value of each node.
    List<long[]> memo = new ArrayList<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // Calling and adding hash to List
        hashSubtreeAtNode(root, true);

        // Storing hashed value of subRoot for comparison
        long[] s = hashSubtreeAtNode(subRoot, false);

        // Check if hash of subRoot is present in memo
        for (long[] m : memo) {
            if (m[0] == s[0] && m[1] == s[1])
                return true;
        }

        return false;
    }
}