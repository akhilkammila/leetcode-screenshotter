class Solution {
public:
    int minBuildTime(vector<int>& blocks, int split) {
        // Prepare Heap of Building Time
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int block : blocks) {
            pq.push(block);
        }

        // Make sibling blocks until we are left with only one root node
        while (pq.size() > 1) {
            // Pop two minimum. The time of the abstracted sub-root will be 
            // split + max(x, y) which is split + y
            int x = pq.top();
            pq.pop();
            int y = pq.top();
            pq.pop();
            pq.push(split + y);
        }

        // Time of final root node
        return pq.top();
    }
};