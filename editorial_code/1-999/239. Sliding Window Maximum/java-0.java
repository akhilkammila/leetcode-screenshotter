class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }
        // Return the result as an array.
        return res.stream().mapToInt(i->i).toArray();
    }
}