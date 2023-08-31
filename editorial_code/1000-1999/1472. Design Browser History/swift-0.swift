class BrowserHistory {
    private var history: [String], future: [String]
    private var current: String

    init(_ homepage: String) {
        history = [String]()
        future = [String]()
        // 'homepage' is the first visited URL.
        current = homepage
    }
    
    func visit(_ url: String) {
        // Push 'current' in 'history' stack and mark 'url' as 'current'.
        history.append(current)
        current = url
        // We need to delete all entries from 'future' stack.
        future = [String]()
    }
    
    func back(_ steps: Int) -> String {
        // Pop elements from 'history' stack, and push elements in 'future' stack.
        for _ in 0..<steps {
            guard !history.isEmpty else { break }
            future.append(current)
            current = history.removeLast()
        }
        return current
    }
    
    func forward(_ steps: Int) -> String {
        // Pop elements from 'future' stack, and push elements in 'history' stack.
        for _ in 0..<steps {
            guard !future.isEmpty else { break }
            history.append(current)
            current = future.removeLast()
        }
        return current
    }
}