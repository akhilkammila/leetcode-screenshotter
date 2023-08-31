class Solution {
    public String parseTernary(String expression) {
        
        // Initialize a stack
        Stack<Character> stack = new Stack<>();
        
        // Traverse the expression from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            
            // If stack top is ?, then replace next four characters
            // with E1 or E2 depending on the value of B
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char onTrue = stack.pop();
                stack.pop();
                char onFalse = stack.pop();
                stack.push(expression.charAt(i) == 'T' ? onTrue : onFalse);
            }
            
            // Otherwise, push this character
            else {
                stack.push(expression.charAt(i));
            }
        }
        
        // Return the final character
        return String.valueOf(stack.peek());
    }
}