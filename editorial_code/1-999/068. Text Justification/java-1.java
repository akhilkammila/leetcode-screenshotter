private String createLine(List<String> line, int i, String[] words, int maxWidth) {
    int baseLength = -1;
    for (String word: line) {
        baseLength += word.length() + 1;
    }
    
    int extraSpaces = maxWidth - baseLength;
    
    if (line.size() == 1 || i == words.length) {
        return String.join(" ", line) + " ".repeat(extraSpaces);
    }
    
    int wordCount = line.size() - 1;
    int spacesPerWord = extraSpaces / wordCount;
    int needsExtraSpace = extraSpaces % wordCount;
    
    for (int j = 0; j < needsExtraSpace; j++) {
        line.set(j, line.get(j) + " ");
    }
    
    for (int j = 0; j < wordCount; j++) {
        line.set(j, line.get(j) + " ".repeat(spacesPerWord));
    }
    
    return String.join(" ",  line);
}