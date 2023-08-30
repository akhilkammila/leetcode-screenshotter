class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Serialize given Nodes
        StringBuilder rootList = new StringBuilder();
        serialize(root, rootList);
        String r = rootList.toString();

        StringBuilder subRootList = new StringBuilder();
        serialize(subRoot, subRootList);
        String s = subRootList.toString();

        // Check if s is in r
        return kmp(s, r);
    }

    // Function to serialize Tree
    private void serialize(TreeNode node, StringBuilder treeStr) {
        if (node == null) {
            treeStr.append("#");
            return;
        }

        treeStr.append("^");
        treeStr.append(node.val);
        serialize(node.left, treeStr);
        serialize(node.right, treeStr);
    }

    // Knuth-Morris-Pratt algorithm to check if `needle` is in `haystack` or not
    private boolean kmp(String needle, String haystack) {
        int m = needle.length();
        int n = haystack.length();

        if (n < m)
            return false;

        // longest proper prefix which is also suffix
        int[] lps = new int[m];
        // Length of Longest Border for prefix before it.
        int prev = 0;
        // Iterating from index-1. lps[0] will always be 0
        int i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(prev)) {
                // Length of Longest Border Increased
                prev += 1;
                lps[i] = prev;
                i += 1;
            } else {
                // Only empty border exist
                if (prev == 0) {
                    lps[i] = 0;
                    i += 1;
                } else {
                    // Try finding longest border for this i with reduced prev
                    prev = lps[prev - 1];
                }
            }
        }

        // Pointer for haystack
        int haystackPointer = 0;
        // Pointer for needle.
        // Also indicates number of characters matched in current window.
        int needlePointer = 0;

        while (haystackPointer < n) {
            if (haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {
                // Matched Increment Both
                needlePointer += 1;
                haystackPointer += 1;
                // All characters matched
                if (needlePointer == m)
                    return true;
            } else {
                if (needlePointer == 0) {
                    // Zero Matched
                    haystackPointer += 1;
                } else {
                    // Optimally shift left needlePointer. Don't change haystackPointer
                    needlePointer = lps[needlePointer - 1];
                }
            }
        }
        return false;
    }
}