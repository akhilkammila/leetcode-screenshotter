class Solution {
public List<TreeNode> generateTrees(int n) {
        List<List<List<TreeNode>>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            List<List<TreeNode>> innerList = new ArrayList<>(n + 1);
            for (int j = 0; j <= n; j++) {
                innerList.add(new ArrayList<>());
            }
            dp.add(innerList);
        }

        for (int i = 1; i <= n; i++) {
            dp.get(i).get(i).add(new TreeNode(i));
        }

        for (int numberOfNodes = 2; numberOfNodes <= n; numberOfNodes++) {
            for (int start = 1; start <= n - numberOfNodes + 1; start++) {
                int end = start + numberOfNodes - 1;
                for (int i = start; i <= end; i++) {
                    List<TreeNode> leftSubtrees =
                        (i != start) ? dp.get(start).get(i - 1) : new ArrayList<>();
                    if (leftSubtrees.isEmpty()) {
                        leftSubtrees.add(null);
                    }
                    List<TreeNode> rightSubtrees =
                        (i != end) ? dp.get(i + 1).get(end) : new ArrayList<>();
                    if (rightSubtrees.isEmpty()) {
                        rightSubtrees.add(null);
                    }

                    for (TreeNode left : leftSubtrees) {
                        for (TreeNode right : rightSubtrees) {
                            TreeNode root = new TreeNode(i, left, right);
                            dp.get(start).get(end).add(root);
                        }
                    }
                }
            }
        }
        return dp.get(1).get(n);
    }
}