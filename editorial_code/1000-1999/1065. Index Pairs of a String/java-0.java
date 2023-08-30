class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> result = new ArrayList();
        Set<String> wordsSet = Arrays.stream(words).collect(Collectors.toSet());
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                if (wordsSet.contains(text.substring(i, j + 1))) {
                    result.add(new int[] {i, j});
                }
            }
        }
        int[][] ans = new int[result.size()][];
        ans = result.toArray(ans);
        return ans;
    }
}