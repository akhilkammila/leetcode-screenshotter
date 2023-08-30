class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Creates a new string by combining all the strings in word1.
        StringBuilder word1Combined = new StringBuilder();
        for (String s : word1) {
            word1Combined.append(s);
        }
        // Creates a new string by combining all the strings in word2.
        StringBuilder word2Combined = new StringBuilder();
        for (String s : word2) {
            word2Combined.append(s);
        }
        // Returns true if both string are the same.
        return word1Combined.compareTo(word2Combined) == 0;
    }
}