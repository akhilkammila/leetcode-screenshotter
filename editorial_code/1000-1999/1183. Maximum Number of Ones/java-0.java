class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        List<Integer> count = new ArrayList<>();
        
        for (int r = 0; r < sideLength; ++r) {
            for (int c = 0; c < sideLength; ++c) {
                count.add((1 + (width - 1 - c) / sideLength) * (1 + (height - 1 - r) / sideLength));   
            }
        }
        
        count.sort(Comparator.reverseOrder());
        int answer = 0;
        for (int i = 0; i < maxOnes; ++i) {
            answer += count.get(i);
        }
        
        return answer;
    }
}