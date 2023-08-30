class Solution {
    public String parseTernary(String expression) {
        
        // Initialize a stack
        Stack<Character> stack = new Stack<>();
        int i = expression.length() - 1;

        // Traverse the expression from right to left
        while (i >= 0) {

            // Current character
            char curr = expression.charAt(i);
            
            // Push every T, F, and digit on the stack
            if (curr >= '0' && curr <= '9' || curr == 'T' || curr == 'F') {
                stack.push(curr);
            }
            
            // As soon as we encounter ?, 
            // replace top two elements of the stack with one
            else if (curr == '?') {
                char onTrue = stack.pop();
                char onFalse = stack.pop();
                stack.push(expression.charAt(i - 1) == 'T' ? onTrue : onFalse);
                
                // Decrement i by 1 as we have already used
                // Previous Boolean character
                i--;
            }
            
            // Go to the previous character
            i--;
        }
        
        // Return the final character
        return String.valueOf(stack.peek());
    }
}