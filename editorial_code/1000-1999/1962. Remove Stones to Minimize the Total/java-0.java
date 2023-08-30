class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int num: piles) {
            heap.add(num);
        }
        
        for (int i = 0; i < k; i++) {
            int curr = heap.remove();
            int remove = curr / 2;
            heap.add(curr - remove);
        }
        
        int ans = 0;
        for (int num: heap) {
            ans += num;
        }
        
        return ans;
    }
}