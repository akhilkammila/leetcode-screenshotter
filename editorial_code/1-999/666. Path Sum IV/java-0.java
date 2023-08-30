class Solution {
    int ans = 0;
    public int pathSum(int[] nums) {
        Node root = new Node(nums[0] % 10);
        for (int num: nums) {
            if (num == nums[0]) continue;
            int depth = num / 100, pos = num / 10 % 10, val = num % 10;
            pos--;
            Node cur = root;
            for (int d = depth - 2; d >= 0; --d) {
                if (pos < 1<<d) {
                    if (cur.left == null) cur.left = new Node(val);
                    cur = cur.left;
                } else {
                    if (cur.right == null) cur.right = new Node(val);
                    cur = cur.right;
                }
                pos %= 1<<d;
            }
        }

        dfs(root, 0);
        return ans;
    }

    public void dfs(Node node, int sum) {
        if (node == null) return;
        sum += node.val;
        if (node.left == null && node.right == null) {
            ans += sum;
        } else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
    }
}

class Node {
    Node left, right;
    int val;
    Node(int v) {val = v;}
}