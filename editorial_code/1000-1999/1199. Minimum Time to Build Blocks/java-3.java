class Solution {
    public int minBuildTime(int[] blocks, int split) {
        // Prepare Heap of Building Time
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int block : blocks) {
            pq.offer(block);
        }

        // Make sibling blocks until we are left with only one root node
        while (pq.size() > 1) {
            // Pop two minimum. The time of the abstracted sub-root will be 
            // split + max(x, y) which is split + y
            int x = pq.poll();
            int y = pq.poll();
            pq.offer(split + y);
        }

        // Time of final root node
        return pq.poll();
    }
}