class BrowserHistory {
    vector<string> visitedURLs;
    int currURL, lastURL;
public:
    BrowserHistory(string homepage) {
        // 'homepage' is the first visited URL.
        visitedURLs.push_back(homepage);
        currURL = 0; 
        lastURL = 0;
    }
    
    void visit(string url) {
        currURL += 1;
        if (visitedURLs.size() > currURL) {
            // We have enough space in our array to overwrite an old 'url' entry with new one.
            visitedURLs[currURL] = url;
        } else {
            // We have to insert a new 'url' entry at the end.
            visitedURLs.push_back(url);
        }
        // This 'url' will be last URL if we try to go forward.
        lastURL = currURL;
    }
    
    string back(int steps) {
        // Move 'currURL' pointer in left direction.
        currURL = max(0, currURL - steps);
        return visitedURLs[currURL];
    }
    
    string forward(int steps) {
        // Move 'currURL' pointer in right direction.
        currURL = min(lastURL, currURL + steps);
        return visitedURLs[currURL];
    }
};