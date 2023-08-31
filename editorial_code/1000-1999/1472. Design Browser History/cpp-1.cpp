class DLLNode {
public:
    string data;
    DLLNode *prev, *next;

    DLLNode(string url) {
        data = url;
        prev = NULL;
        next = NULL;
    }
};

class BrowserHistory {
public:
    DLLNode* linkedListHead;
    DLLNode* current;

    BrowserHistory(string homepage) {
        // 'homepage' is the first visited URL.
        linkedListHead = new DLLNode(homepage);
        current = linkedListHead;
    }
    
    void visit(string url) {
        // Insert new node 'url' in the right of current node.
        DLLNode* newNode = new DLLNode(url);
        current->next = newNode;
        newNode->prev = current;
        // Make this new node as current node now.
        current = newNode;
    }
    
    string back(int steps) {
        // Move 'current' pointer in left direction.
        while (steps > 0 && current->prev != NULL) {
            current = current->prev;
            steps--;
        }
        return current->data;
    }
    
    string forward(int steps) {
        // Move 'current' pointer in right direction.
        while (steps > 0 && current->next != NULL) {
            current = current->next;
            steps--;
        }
        return current->data;
    }
};