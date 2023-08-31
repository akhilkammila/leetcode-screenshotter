class DLLNode {
    public String data;
    public DLLNode prev, next;

    DLLNode(String url) {
        data = url;
        prev = null;
        next = null;
    }
};

class BrowserHistory {
    private DLLNode linkedListHead;
    private DLLNode current;

    public BrowserHistory(String homepage) {
        // 'homepage' is the first visited URL.
        linkedListHead = new DLLNode(homepage);
        current = linkedListHead;
    }
    
    public void visit(String url) {
        // Insert new node 'url' in the right of current node.
        DLLNode newNode = new DLLNode(url);
        current.next = newNode;
        newNode.prev = current;
        // Make this new node as current node now.
        current = newNode;
    }
    
    public String back(int steps) {
        // Move 'current' pointer in left direction.
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.data;
    }
    
    public String forward(int steps) {
        // Move 'current' pointer in right direction.
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.data;
    }
}