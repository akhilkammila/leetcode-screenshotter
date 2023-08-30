class Solution {
public:
    string parseTernary(string expression) {
        
        // Initialize a stack
        stack<char> stack;
        int i = expression.size() - 1;

        // Traverse the expression from right to left
        while (i >= 0) {

            // Current character
            char curr = expression[i];
            
            // Push every T, F, and digit on the stack
            if (curr >= '0' && curr <= '9' || curr == 'T' || curr == 'F') {
                stack.push(curr);
            }
            
            // As soon as we encounter ?, 
            // replace top two elements of the stack with one
            else if (curr == '?') {
                char onTrue = stack.top();
                stack.pop();
                char onFalse = stack.top();
                stack.pop();
                stack.push(expression[i - 1] == 'T' ? onTrue : onFalse);
                
                // Decrement i by 1 as we have already used
                // Previous Boolean character
                i--;
            }
            
            // Go to the previous character
            i--;
        }
        
        // Return the final character
        return string(1, stack.top());
    }
};