class Solution {
public:
    string convertToTitle(int columnNumber) {
        string ans;
        
        while (columnNumber) {
            columnNumber--;
            // Get the last character and append it at the end of string.
            ans = ans + (char)((columnNumber) % 26 + 'A');
            columnNumber = (columnNumber) / 26;
        }
        
        // Reverse it, as we appended characters in reverse order.
        reverse(ans.begin(), ans.end());
        return ans;
    }
};