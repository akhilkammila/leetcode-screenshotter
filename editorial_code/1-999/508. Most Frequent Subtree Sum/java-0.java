class Solution {
    private HashMap<Integer, Integer> sumFreq = new HashMap<Integer, Integer>();
    private Integer maxFreq = 0;
    
    private int findTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Current root's tree's sum.
        return root.val + findTreeSum(root.left) + findTreeSum(root.right);
    }
    
    private void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // Find current node's tree's sum.
        int currSum = findTreeSum(root);
        sumFreq.put(currSum, sumFreq.getOrDefault(currSum, 0) + 1);
        maxFreq = Math.max(maxFreq, sumFreq.get(currSum));
        
        // Iterate on left and right subtrees and find their sums.
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        // Traverse on all nodes one by one, and find it's tree's sum.
        preOrderTraversal(root);
        
        List<Integer> ansList = new ArrayList<Integer>(); 
        for (Map.Entry<Integer, Integer> mapElement : sumFreq.entrySet()) {
            Integer sum = mapElement.getKey();
            Integer freq = mapElement.getValue();
            
            if (freq == maxFreq) {
                ansList.add(sum);
            }
        }
        
        int maxFreqSums[] = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            maxFreqSums[i] =  ansList.get(i).intValue();
        }
        
        return maxFreqSums;
    }
}