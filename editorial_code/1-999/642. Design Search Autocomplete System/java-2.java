public List<String> input(char c) {
    if (c == '#') {
        addToTrie(currSentence.toString(), 1);
        currSentence.setLength(0);
        currNode = root;
        return new ArrayList<String>();
    }
    
    currSentence.append(c);
    if (!currNode.children.containsKey(c)) {
        currNode = dead;
        return new ArrayList<String>();
    }
    
    currNode = currNode.children.get(c);
    List<String> sentences = new ArrayList<>(currNode.sentences.keySet());
    Collections.sort(sentences, (a, b) -> {
        int hotA = currNode.sentences.get(a);
        int hotB = currNode.sentences.get(b);
        if (hotA == hotB) {
            return a.compareTo(b);
        }
        
        return hotB - hotA;
    });
    
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < Math.min(3, sentences.size()); i++) {
        ans.add(sentences.get(i));
    }
    
    return ans;
}