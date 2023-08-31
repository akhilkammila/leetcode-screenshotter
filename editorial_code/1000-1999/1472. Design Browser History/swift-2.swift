class BrowserHistory {
    private var visitedURLs: [String]
    private var currURL: Int
    private var lastURL: Int

    init(_ homepage: String) {
        // 'homepage' is the first visited URL.
        visitedURLs = [homepage]
        currURL = 0
        lastURL = 0
    }
    
    func visit(_ url: String) {
        currURL += 1
        if visitedURLs.count > currURL {
            // We have enough space in our array to overwrite an old 'url' entry with new one.
            visitedURLs[currURL] = url
        } else {
            // We have to insert a new 'url' entry at the end.
            visitedURLs.append(url)
        }
        // This 'url' will be last URL if we try to go forward.
        lastURL = currURL
    }
    
    func back(_ steps: Int) -> String {
        // Move 'currURL' pointer in left direction.
        currURL = max(0, currURL - steps)
        return visitedURLs[currURL]
    }
    
    func forward(_ steps: Int) -> String {
        // Move 'currURL' pointer in right direction.
        currURL = min(lastURL, currURL + steps)
        return visitedURLs[currURL]
    }
}