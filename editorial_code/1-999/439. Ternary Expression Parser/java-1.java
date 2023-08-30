class Solution {
    public String parseTernary(String expression) {
        
        // Reduce expression until we are left with a single character
        while (expression.length() != 1) {
            int questionMarkIndex = expression.length() - 1;
            while (expression.charAt(questionMarkIndex) != '?') {
                questionMarkIndex--;
            }
            
            // Find the value of the expression.
            char value;
            if (expression.charAt(questionMarkIndex - 1) == 'T') {
                value = expression.charAt(questionMarkIndex + 1);
            } else {
                value = expression.charAt(questionMarkIndex + 3);
            }
            
            // Replace the expression with the value
            expression = expression.substring(0, questionMarkIndex - 1) + value + expression.substring(questionMarkIndex + 4);
        }
        
        // Return the final character
        return expression;
    }
}