class Solution {
    public String parseTernary(String expression) {
        return solve(expression, 0, expression.length() - 1);
    }
    
    private String solve(String expression, int i, int j) {
        
        // If expression is a single character, return it
        if (i == j) {
            return expression.substring(i, i + 1);
        }
        
        // Find the index of ?
        int questionMarkIndex = i;
        while (expression.charAt(questionMarkIndex) != '?') {
            questionMarkIndex++;
        }
        
        // Find one index after corresponding :
        int aheadColonIndex = questionMarkIndex + 1;
        int count = 1;
        while (count != 0) {
            if (expression.charAt(aheadColonIndex) == '?') {
                count++;
            } else if (expression.charAt(aheadColonIndex) == ':') {
                count--;
            }
            aheadColonIndex++;
        }
        
        // Check the value of B and recursively solve
        if (expression.charAt(i) == 'T') {
            return solve(expression, questionMarkIndex + 1, aheadColonIndex - 2);
        } else {
            return solve(expression, aheadColonIndex, j);
        }
    }
}