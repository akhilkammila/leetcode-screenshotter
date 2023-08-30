class Solution {
    int storeFirstOptions(String s, int startPos, List<Character> firstOptions) {
        // If the first character is not '{', it means a single character
        if (s.charAt(startPos) != '{') {
            firstOptions.add(s.charAt(startPos));
        } else {
            // Store all the characters between '{' and '}'
            while (s.charAt(startPos) != '}') {
                 if (s.charAt(startPos) >= 'a' && s.charAt(startPos) <= 'z') {
                     firstOptions.add(s.charAt(startPos));
                 }
                startPos++;
            }
            // Sort the list
            Collections.sort(firstOptions);
        }
        // Increment it to point to the next character to be considered
        return startPos + 1;
    }
    
    String[] findAllWords(String s, int startPos) {
        // Return empty string list if the string is empty
        if (startPos == s.length()) {
            return new String[] {""};
        }
        
        List<Character> firstOptions = new ArrayList<>();
        // Store the characters for the first index as string in firstOptions
        int remStringStartPos = storeFirstOptions(s, startPos, firstOptions);
        String[] wordsWithRemString = findAllWords(s, remStringStartPos);
        
        List<String> expandedWords = new ArrayList<>();
        // Create new words by adding the character at the beginning
        for (Character c : firstOptions) {
            for (String word : wordsWithRemString) {
                expandedWords.add(c + word);
            }
        }
        
        return expandedWords.toArray(new String[0]);
    }
    
    public String[] expand(String s) {
        return findAllWords(s, 0);
    }
}