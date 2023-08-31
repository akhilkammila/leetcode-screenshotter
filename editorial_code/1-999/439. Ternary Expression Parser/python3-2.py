class Solution:
    def parseTernary(self, expression: str) -> str:
        
        # Initialize a stack
        stack = []
        i = len(expression) - 1

        # Traverse the expression from right to left
        while i >= 0:

            # Current character
            char = expression[i]
            
            # Push every T, F, and digit on the stack
            if char in 'TF0123456789':
                stack.append(char)
            
            # As soon as we encounter ?, 
            # replace top two elements of the stack with one
            elif char == '?':
                onTrue = stack.pop()
                onFalse = stack.pop()
                stack.append(onTrue if expression[i - 1] == 'T' else onFalse)
                
                # Decrement i by 1 as we have already used
                # Previous Boolean character
                i -= 1
            
            # Go to the previous character
            i -= 1
        
        # Return the final character
        return stack[0]