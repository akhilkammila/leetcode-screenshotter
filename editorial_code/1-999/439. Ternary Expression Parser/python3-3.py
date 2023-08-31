class Solution:
    def parseTernary(self, expression: str) -> str:
        
        # Initialize a stack
        stack = []
        
        # Traverse the expression from right to left
        for char in expression[::-1]:
            
            # If stack top is ?, then replace next four characters
            # with E1 or E2 depending on the value of B
            if stack and stack[-1] == '?':
                stack.pop()
                onTrue = stack.pop()
                stack.pop()
                onFalse = stack.pop()
                stack.append(onTrue if char == 'T' else onFalse)
            
            # Otherwise, push this character
            else:
                stack.append(char)
        
        # Return the final character
        return stack[0]