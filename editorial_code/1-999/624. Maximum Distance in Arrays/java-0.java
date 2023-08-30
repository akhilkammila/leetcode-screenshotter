class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int n = arrays.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < arrays.get(i).size(); j++) {
                for (int k = i + 1; k < n; k++) {
                    for (int l = 0; l < arrays.get(k).size(); l++) {
                        res = Math.max(res, Math.abs(arrays.get(i).get(j) - arrays.get(k).get(l)));
                    }
                }
            }
        }
        return res;
    }
}