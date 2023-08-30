class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Find out the greatest number of candies among all the kids.
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(candy, maxCandies);
        }
        // For each kid, check if they will have greatest number of candies
        // among all the kids.
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}