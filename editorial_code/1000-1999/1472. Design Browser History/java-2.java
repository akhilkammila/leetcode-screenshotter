class BrowserHistory {
    ArrayList<String> visitedURLs;
    int currURL, lastURL;

    public BrowserHistory(String homepage) {
        // 'homepage' is the first visited URL.
        visitedURLs = new ArrayList<String>(Arrays.asList(homepage));
        currURL = 0; 
        lastURL = 0;
    }
    
    public void visit(String url) {
        currURL += 1;
        if (visitedURLs.size() > currURL) {
            // We have enough space in our array to overwrite an old 'url' entry with new one.
            visitedURLs.set(currURL, url);
        } else {
            // We have to insert a new 'url' entry at the end.
            visitedURLs.add(url);
        }
        // This 'url' will be last URL if we try to go forward.
        lastURL = currURL;
    }
    
    public String back(int steps) {
        // Move 'currURL' pointer in left direction.
        currURL = Math.max(0, currURL - steps);
        return visitedURLs.get(currURL);
    }
    
    public String forward(int steps) {
        // Move 'currURL' pointer in right direction.
        currURL = Math.min(lastURL, currURL + steps);
        return visitedURLs.get(currURL);
    }
}