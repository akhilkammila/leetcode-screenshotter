class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        String answer = "";
        HashMap<Character, ArrayList<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character c = s1.charAt(i);
            if (!indices.containsKey(c)) {
                indices.put(c, new ArrayList<>());
            }
            indices.get(c).add(i);
        }
        int ind[] = new int[m];
        for (int start = 0; start < n; start++) {
            int prev = start - 1;
            for (int j = 0; j < m; j++) {
                if (!indices.containsKey(s2.charAt(j))) {
                    return "";
                }
                ArrayList<Integer> curIndices = indices.get(s2.charAt(j));
                while (ind[j] < curIndices.size() && curIndices.get(ind[j]) <= prev) {
                    ind[j]++;
                }
                if (ind[j] == curIndices.size()) {
                    return answer;
                }
                prev = curIndices.get(ind[j]);
            }
            if (answer.isEmpty() || prev - start + 1 < answer.length()) {
                answer = s1.substring(start, prev + 1);
            }
        }
        return answer;
    }
}