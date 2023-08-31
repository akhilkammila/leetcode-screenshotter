class Solution {
    public String parseTernary(String expression) {
        
        // Pointer for Traversal. It will maintain Loop Invariant.
        int i = 0;
        
        // Loop invariant: We will always be at the first character of 
        // expression which we should FOCUS on.
        while (true) {
            
            // If this first character is not boolean, it means no nesting
            // is there. Thus, we can simply return this character.
            if (expression.charAt(i) != 'T' && expression.charAt(i) != 'F') {
                return String.valueOf(expression.charAt(i));
            }
            
            // If this is last character, then we can simply return this
            if (i == expression.length() - 1) {
                return String.valueOf(expression.charAt(i));
            }
            
            // If succeeding character is :, it means we have processed
            // the FOCUS part. Ignore the ahead part and return this character.
            if (expression.charAt(i + 1) == ':') {
                return String.valueOf(expression.charAt(i));
            }

            // Now it means this character is boolean followed by ?.
            // If this boolean is T, then process after ? sub-expression.
            if (expression.charAt(i) == 'T') {
                i = i + 2;
            }
            
            // If this boolean is F, then make i point to the character
            // after ": of this ?". To have corresponding :, we 
            // can maintain count
            else {
                int count = 1;
                i = i + 2;
                while (count != 0) {
                    if (expression.charAt(i) == ':') {
                        count--;
                    } else if (expression.charAt(i) == '?') {
                        count++;
                    }
                    i++;
                }
            }
        }
    }
}