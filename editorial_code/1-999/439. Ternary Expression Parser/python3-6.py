class Solution:
    def parseTernary(self, expression: str) -> str:
        
        # Pointer for Traversal. It will maintain Loop Invariant.
        i = 0
        
        # Loop invariant: We will always be at the first character of 
        # expression which we should FOCUS on.
        while True:
            
            # If this first character is not boolean, it means no nesting
            # is there. Thus, we can simply return this character.
            if expression[i] not in 'TF':
                answer = expression[i]
                break
            
            # If this is last character, then we can simply return this
            if i == len(expression) - 1:
                answer = expression[i]
                break
            
            # If succeeding character is :, it means we have processed
            # the FOCUS part. Ignore the ahead part and return this character.
            if expression[i + 1] == ':':
                answer = expression[i]
                break

            # Now it means this character is boolean followed by ?.
            # If this boolean is T, then process after ? sub-expression.
            if expression[i] == 'T':
                i = i + 2
            
            # If this boolean is F, then make i point to the character
            # after ": of this ?". To have corresponding :, we 
            # can maintain count
            else:
                count = 1
                i = i + 2
                while count != 0:
                    if expression[i] == ':':
                        count -= 1
                    elif expression[i] == '?':
                        count += 1
                    i += 1
        
        # Return Answer Character
        return answer