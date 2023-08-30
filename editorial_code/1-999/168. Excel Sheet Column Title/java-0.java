class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        
        while(columnNumber > 0) {
            columnNumber--;
            // Get the last character and append it at the end of the string.
            ans.append((char)((columnNumber) % 26 + 'A'));
            columnNumber = (columnNumber) / 26;
        }
        
        // Reverse it, as we appended characters in reverse order.
        return ans.reverse().toString();
    }
}