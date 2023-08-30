class Solution {
    public String parseTernary(String expression) {
        
        // Checks if the string s is a valid atomic expression
        Predicate<String> isValidAtomic = s -> (s.charAt(0) == 'T' || s.charAt(0) == 'F') && s.charAt(1) == '?' && ((s.charAt(2) >= '0' && s.charAt(2) <= '9') || s.charAt(2) == 'T' || s.charAt(2) == 'F') && s.charAt(3) == ':' && ((s.charAt(4) >= '0' && s.charAt(4) <= '9') || s.charAt(4) == 'T' || s.charAt(4) == 'F');
        
        // Returns the value of the atomic expression
        Function<String, String> solveAtomic = s -> s.charAt(0) == 'T' ? s.substring(2, 3) : s.substring(4, 5);
        
        // Reduce expression until we are left with a single character
        while (expression.length() != 1) {
            int j = expression.length() - 1;
            while (!isValidAtomic.test(expression.substring(j-4, j+1))) {
                j--;
            }
            expression = expression.substring(0, j-4) + solveAtomic.apply(expression.substring(j-4, j+1)) + expression.substring(j+1, expression.length());
        }
        
        // Return the final character
        return expression;
    }
}