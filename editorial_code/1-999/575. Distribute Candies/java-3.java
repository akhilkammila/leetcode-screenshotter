class Solution {
    public int distributeCandies(int[] candyType) {
        // Create an empty Hash Set, and add each candy into it.
        Set<Integer> uniqueCandiesSet = new HashSet<>();
        for (int candy: candyType) {
            uniqueCandiesSet.add(candy);
        }
        // Then, find the answer in the same way as before.
        return Math.min(uniqueCandiesSet.size(), candyType.length / 2);
    }
}