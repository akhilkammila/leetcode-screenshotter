private List<String> getWords(int i, String[] words, int maxWidth) {
    List<String> currentLine = new ArrayList<>();
    int currLength = 0;
    
    while (i < words.length && currLength + words[i].length() <= maxWidth) {
        currentLine.add(words[i]);
        currLength += words[i].length() + 1;
        i++;
    }
    
    return currentLine;
}