class BrowserHistory {
    private Stack<String> history, future;
    private String current;
    
    public BrowserHistory(String homepage) {
        history = new Stack<String>();
        future = new Stack<String>();
        // 'homepage' is the first visited URL.
        current = homepage;
    }
    
    public void visit(String url) {
        // Push 'current' in 'history' stack and mark 'url' as 'current'.
        history.push(current);
        current = url;
        // We need to delete all entries from 'future' stack.
        future = new Stack<String>();
    }
    
    public String back(int steps) {
        // Pop elements from 'history' stack, and push elements in 'future' stack.
        while(steps > 0 && !history.empty()) {
            future.push(current);
            current = history.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        // Pop elements from 'future' stack, and push elements in 'history' stack.
        while(steps > 0 && !future.empty()) {
            history.push(current);
            current = future.pop();
            steps--;
        }
        return current;
    }
}