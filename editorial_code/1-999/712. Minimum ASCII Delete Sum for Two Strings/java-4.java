class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        // Make sure s2 is smaller string
        if (s1.length() < s2.length()) {
            return minimumDeleteSum(s2, s1);
        }
        
        // Case for empty s1
        int m = s1.length(), n = s2.length();
        int[] currRow = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            currRow[j] = currRow[j - 1] + s2.charAt(j - 1);
        }
        
        // Compute answer row-by-row
        for (int i = 1; i <= m; i++) {
            
            int diag = currRow[0];
            currRow[0] += s1.charAt(i - 1);
            
            for (int j = 1; j <= n; j++) {

                int answer;
                
                // If characters are the same, the answer is top-left-diagonal value
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    answer = diag;
                }
                
                // Otherwise, the answer is minimum of top and left values with
                // deleted character's ASCII value
                else {
                    answer = Math.min(
                        s1.charAt(i - 1) + currRow[j],
                        s2.charAt(j - 1) + currRow[j - 1]
                    );
                }
                
                // Before overwriting currRow[j] with answer, save it in diag
                // for the next column
                diag = currRow[j];
                currRow[j] = answer;
            }
        }
        
        // Return the answer
        return currRow[n];
    }
}