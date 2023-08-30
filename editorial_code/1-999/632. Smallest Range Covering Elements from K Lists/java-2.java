class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0;
        int miny = Integer.MAX_VALUE;
        int[] next = new int[nums.size()];
        boolean flag = true;
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int min_i = 0, max_i = 0;
                for (int k = 0; k < nums.size(); k++) {
                    if (nums.get(min_i).get(next[min_i]) > nums.get(k).get(next[k]))
                        min_i = k;
                    if (nums.get(max_i).get(next[max_i]) < nums.get(k).get(next[k]))
                        max_i = k;
                }
                if (miny - minx > nums.get(max_i).get(next[max_i]) - nums.get(min_i).get(next[min_i])) {
                    miny = nums.get(max_i).get(next[max_i]);
                    minx = nums.get(min_i).get(next[min_i]);
                }
                next[min_i]++;
                if (next[min_i] == nums.get(min_i).size()) {
                    flag = false;
                }
            }
        }
        return new int[] {minx, miny};
    }
}