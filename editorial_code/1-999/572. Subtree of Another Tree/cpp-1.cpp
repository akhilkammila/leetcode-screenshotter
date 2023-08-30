class Solution {
public:
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
         // Serialize given Nodes
        string r = "";
        serialize(root, r);
        string s = "";
        serialize(subRoot, s);
                 
         // Check if s is in r
         return kmp(s, r);
     }
    
    // Function to serialize Tree
    void serialize(TreeNode* node, string& treeStr) {
        if (node == nullptr){
            treeStr += "#";
            return;
        }

        treeStr += "^";
        treeStr += to_string(node->val);
        serialize(node->left, treeStr);
        serialize(node->right, treeStr);
    }

    // Knuth-Morris-Pratt algorithm to check if `needle` is in `haystack` or not
    bool kmp(string needle, string haystack) {
        int m = needle.length();
        int n = haystack.length();
        
        if (n < m)
            return false;
        
        // longest proper prefix which is also suffix
        vector<int> lps(m);
        // Length of Longest Border for prefix before it.
        int prev = 0;
        // Iterating from index-1. lps[0] will always be 0
        int i = 1;
        
        while (i < m) {
            if (needle[i] == needle[prev]) {
                // Length of Longest Border Increased
                prev += 1;
                lps[i] = prev;
                i += 1;
            } else {
                // Only empty border exist
                if (prev == 0) {
                    lps[i] = 0;
                    i += 1;
                } else {
                    // Try finding longest border for this i with reduced prev
                    prev = lps[prev-1];
                }
            }
        }
        
        // Pointer for haystack
        int haystackPointer = 0;
        // Pointer for needle.
        // Also indicates number of characters matched in current window.
        int needlePointer = 0;
        
        while (haystackPointer < n) {
            if (haystack[haystackPointer] == needle[needlePointer]) {
                // Matched Increment Both
                needlePointer += 1;
                haystackPointer += 1;
                // All characters matched
                if (needlePointer == m)
                    return true;                
            } else {                
                if (needlePointer == 0) {
                    // Zero Matched
                    haystackPointer += 1;                    
                } else {
                    // Optimally shift left needlePointer. Don't change haystackPointer
                    needlePointer = lps[needlePointer-1];
                }
            }
        }
        
        return false;
    }
};