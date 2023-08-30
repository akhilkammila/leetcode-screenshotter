/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class MorrisIterator implements Iterator<Integer> {
    private TreeNode current;
    private TreeNode pre;

    public MorrisIterator(TreeNode root) {
        current = root;
        pre = null;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Integer next() {
        Integer val = null;
        while (current != null) {
            if (current.left == null) {
                val = current.val;
                current = current.right;
                break;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    val = current.val;
                    current = current.right;
                    break;
                }
            }
        }
        return val;
    }
}

class ReversedMorrisIterator implements Iterator<Integer> {
    private TreeNode current;
    private TreeNode pre;

    public ReversedMorrisIterator(TreeNode root) {
        current = root;
        pre = null;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Integer next() {
        Integer val = null;
        while (current != null) {
            if (current.right == null) {
                val = current.val;
                current = current.left;
                break;
            } else {
                pre = current.right;
                while (pre.left != null && pre.left != current) {
                    pre = pre.left;
                }
                if (pre.left == null) {
                    pre.left = current;
                    current = current.right;
                } else {
                    pre.left = null;
                    val = current.val;
                    current = current.left;
                    break;
                }
            }
        }
        return val;
    }
}

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        MorrisIterator iterator1 = new MorrisIterator(root1);
        ReversedMorrisIterator iterator2 = new ReversedMorrisIterator(root2);
        
        int value1 = iterator1.next(), value2 = iterator2.next();
        
        while (value1 != Integer.MIN_VALUE && value2 != Integer.MIN_VALUE) {
            if (value1 + value2 == target) {
                return true;
            } else if (value1 + value2 < target) {
                if (iterator1.hasNext()) {
                    value1 = iterator1.next();
                } else {
                    value1 = Integer.MIN_VALUE;
                }
            } else {
                if (iterator2.hasNext()) {
                    value2 = iterator2.next();
                } else {
                    value2 = Integer.MIN_VALUE;
                }
            }
        }
        
        return false;
    }
}