# @param {String} expression
# @return {String}
def parse_ternary(expression)
    
    # Initialize a stack
    stack = []
    i = expression.length - 1

    # Traverse the expression from right to left
    while i >= 0

        # Current character
        curr = expression[i]
        
        # Push every T, F, and digit on the stack
        if curr >= '0' && curr <= '9' || curr == 'T' || curr == 'F'
            stack.push(curr)
        end
        
        # As soon as we encounter ?, 
        # replace top two elements of the stack with one
        if curr == '?'
            on_true = stack.pop
            on_false = stack.pop
            stack.push(expression[i - 1] == 'T' ? on_true : on_false)
            
            # Decrement i by 1 as we have already used
            # Previous Boolean character
            i -= 1
        end
        
        # Go to the previous character
        i -= 1
    end
    
    # Return the final character
    return stack.pop
end