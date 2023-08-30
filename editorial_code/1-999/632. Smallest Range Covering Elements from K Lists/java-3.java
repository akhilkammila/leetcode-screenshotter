class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0;
        int miny = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];
        boolean flag = true;
        
        PriorityQueue <Integer> min_queue = new PriorityQueue <Integer> ((i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));
        for (int i = 0; i < nums.size(); i++) {
            min_queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int min_i = min_queue.poll();
                if (miny - minx > max - nums.get(min_i).get(next[min_i])) {
                    minx = nums.get(min_i).get(next[min_i]);
                    miny = max;
                }
                next[min_i]++;
                if (next[min_i] == nums.get(min_i).size()) {
                    flag = false;
                    break;
                }
                min_queue.offer(min_i);
                max = Math.max(max, nums.get(min_i).get(next[min_i]));
            }
        }
        return new int[] { minx, miny};
    }
}