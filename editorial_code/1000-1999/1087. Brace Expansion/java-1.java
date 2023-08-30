class Solution {
    int storeFirstOptions(String s, int startPos, List<String> firstOptions) {
        // If the first character is not '{', it means a single character
        if (s.charAt(startPos) != '{') {
            firstOptions.add(String.valueOf(s.charAt(startPos)));
        } else {
            // Store all the characters between '{' and '}'
            while (s.charAt(startPos) != '}') {
                if (s.charAt(startPos) >= 'a' && s.charAt(startPos) <= 'z') {
                    firstOptions.add(String.valueOf(s.charAt(startPos)));
                }
                startPos++;
            }
            // Sort the list
            Collections.sort(firstOptions);
        }
        // Increment it to point to the next character to be considered
        return startPos + 1;
    }
    
    String[] expand(String s) {
        List<String> expandedWords = Arrays.asList("");
        
        int startPos = 0;
        while (startPos < s.length()) {
            List<String> firstOptions = new ArrayList<>();
            // Store the characters for the first index as string in firstOptions
            int remStringStartPos = storeFirstOptions(s, startPos, firstOptions);
            
            List<String> currWords = new ArrayList<>();
            // Append the string in the list firstOptions to string in expandedWords
            for (String word : expandedWords) {
                for (String c : firstOptions) {
                    currWords.add(word + c);
                }
            }
            // Update the list expandedWords to have all the words
            expandedWords = currWords;
            // Pointing to the next character to be considered
            startPos = remStringStartPos;
        }
        
        return expandedWords.toArray(new String[0]);
    }
}