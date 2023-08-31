class DLLNode {
    var data: String
    var prev: DLLNode? = nil
    var next: DLLNode? = nil

    init(_ url: String) {
        data = url
    }
}

class BrowserHistory {
    private var linkedListHead: DLLNode
    private var current: DLLNode

    init(_ homepage: String) {
        // 'homepage' is the first visited URL.
        linkedListHead = DLLNode(homepage)
        current = linkedListHead
    }
    
    func visit(_ url: String) {
        // Insert new node 'url' in the right of current node.
        let newNode = DLLNode(url)
        current.next = newNode
        newNode.prev = current
        // Make this new node as current node now.
        current = newNode
    }
    
    func back(_ steps: Int) -> String {
        // Move 'current' pointer in left direction.
        for _ in 0..<steps {
            guard current.prev != nil else { break }
            current = current.prev!
        }
        return current.data
    }
    
    func forward(_ steps: Int) -> String {
        // Move 'current' pointer in right direction.
        for _ in 0..<steps {
            guard current.next != nil else { break }
            current = current.next!
        }
        return current.data
    }
}