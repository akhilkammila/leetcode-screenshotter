class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0;
        int miny = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                for (int k = i; k < nums.size(); k++) {
                    for (int l = (k == i ? j : 0); l < nums.get(k).size(); l++) {
                        int min = Math.min(nums.get(i).get(j), nums.get(k).get(l));
                        int max = Math.max(nums.get(i).get(j), nums.get(k).get(l));
                        int n, m;
                        for (m = 0; m < nums.size(); m++) {
                            n = Collections.binarySearch(nums.get(m), min);
                            if (n < 0)
                                n = -1 - n;
                            if (n == nums.get(m).size() || nums.get(m).get(n) < min || nums.get(m).get(n) > max)
                                break;
                        }
                        if (m == nums.size()) {
                            if (miny - minx > max - min || (miny - minx == max - min && minx > min)) {
                                miny = max;
                                minx = min;
                            }
                        }
                    }
                }
            }
        }
        return new int[] {minx, miny};
    }
}