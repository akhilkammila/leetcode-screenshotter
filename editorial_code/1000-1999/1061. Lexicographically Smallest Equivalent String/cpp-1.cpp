class Solution {
public:
    array<int, 26> representative;
    
    // Returns the root representative of the component.
    int find(int x) {
        if (representative[x] == x) {
            return x;
        }
        
        return representative[x] = find(representative[x]);
    }
    
    // Perform union if x and y aren't in the same component.
    void performUnion(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) {
            return;
        }
        
        // Make the smaller character representative.
        if (x < y) {
            representative[y] = x;
        } else {
            representative[x] = y;
        }
    }
    
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        // Make each character representative of itself.
        for (int i = 0; i < 26; i++) {
            representative[i] = i;
        }
        
        // Perform union merge for all the edges.
        for (int i = 0; i < s1.size(); i++) {
            performUnion(s1[i] - 'a', s2[i] - 'a');
        }
        
        string ans;
        // Create the answer string with final mappings.
        for (char c : baseStr) {
            ans += (char)(find(c - 'a') + 'a');
        }
        
        return ans;
    }
};