class Solution {
    public int distributeCandies(int[] candyType) {
        // Initiate a variable to count how many unique candies are in the array.
        int uniqueCandies = 0;
        // For each candy, we're going to check whether or not we've already
        // seen a candy identical to it.
        for (int i = 0; i < candyType.length; i++) {
            // Start by assuming that the candy IS unique.
            boolean isUnique = true;
            // Check each candy BEFORE this candy.
            for (int j = 0; j < i; j++) {
                // If this candy is the same as a previous one, it isn't unique.
                if (candyType[i] == candyType[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueCandies++;
            }
        }
        // The answer is the minimum out of the number of unique candies, and 
        // half the length of the candyType array.
        return Math.min(uniqueCandies, candyType.length / 2);
    }
}